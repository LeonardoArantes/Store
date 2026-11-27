package br.com.back.product.management.adapter.input.controller;

import br.com.back.product.management.adapter.input.controller.dto.request.ProductRequest;
import br.com.back.product.management.adapter.input.controller.mapper.ProductMapper;
import br.com.back.product.management.core.model.Product;
import br.com.back.product.management.port.input.ProductManagementInputPort;
import br.com.back.product.management.port.output.LoggerOutputPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import tools.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.util.Map;

import static br.com.back.product.management.factory.ProductFactory.createValidProductRequest;
import static br.com.back.product.management.factory.ProductFactory.toProduct;
import static br.com.back.product.management.factory.ProductFactory.validPaylaod;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
@ActiveProfiles("test")
@DisplayName("ProductController")
public class ProductControllerTest {

    private static String EXCEED_LIMIT = "000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductMapper productMapper;

    @MockitoBean
    private ProductManagementInputPort productManagementInputPort;

    @MockitoBean
    private LoggerOutputPort loggerOutputPort;

    @Autowired
    private ObjectMapper objectMapper;

    @Nested
    @DisplayName("POST /product/create")
    class CreateProduct {
        @Test
        @DisplayName("Should create product and return 201")
        void shouldCreateProductAndReturn201() throws Exception {
            var productRequest = createValidProductRequest();
            var product = toProduct(productRequest);

            given(productMapper.toDomain(any(ProductRequest.class))).willReturn(product);
            willDoNothing().given(productManagementInputPort).createProduct(any(Product.class));

            postProduct(validPaylaod())
                    .andExpect(status().isCreated());
        }

        @Test
        @DisplayName("Should return SKU is required")
        void ShouldReturnSKUIsRequired() throws Exception {
            var productRequest = validPaylaod();
            productRequest.put("sku", "");

            postProduct(productRequest)
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.errors[?(@.field == 'sku')].message")
                    .value("SKU is required."));

            then(productManagementInputPort).shouldHaveNoInteractions();
        }

        @Test
        @DisplayName("Should return Product name is required")
        void ShouldReturnProductNameIsRequired() throws Exception {
            var productRequest = validPaylaod();
            productRequest.put("name", "");

            postProduct(productRequest)
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.errors[?(@.field == 'name')].message")
                            .value("Product name is required."));

            then(productManagementInputPort).shouldHaveNoInteractions();
        }

        @Test
        @DisplayName("Should return Cost price is required")
        void ShouldReturnCostpriceIsRequired() throws Exception {
            var productRequest = validPaylaod();
            productRequest.put("costPrice", "");

            postProduct(productRequest)
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.errors[?(@.field == 'costPrice')].message")
                            .value("Cost price is required."));

            then(productManagementInputPort).shouldHaveNoInteractions();
        }

        @Test
        @DisplayName("Should return Sell price is required")
        void ShouldReturnSellPriceIsRequired() throws Exception {
            var productRequest = validPaylaod();
            productRequest.put("sellPrice", "");

            postProduct(productRequest)
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.errors[?(@.field == 'sellPrice')].message")
                            .value("Sell price is required."));

            then(productManagementInputPort).shouldHaveNoInteractions();
        }

        @Test
        @DisplayName("Should return Product weight is required.")
        void ShouldReturnproductWeightIsRequired() throws Exception {
            var productRequest = validPaylaod();
            productRequest.put("weight", "");

            postProduct(productRequest)
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.errors[?(@.field == 'weight')].message")
                            .value("Product weight is required."));

            then(productManagementInputPort).shouldHaveNoInteractions();
        }

        @Test
        @DisplayName("Should return Product weight must be greater than zero")
        void ShouldReturnproductWeightMustBeGreaterThanZero() throws Exception {
            var productRequest = validPaylaod();
            productRequest.put("weight", "-1.000");

            postProduct(productRequest)
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.errors[?(@.field == 'weight')].message")
                    .value("Product weight must be greater than zero."));

            then(productManagementInputPort).shouldHaveNoInteractions();
        }

        @Test
        @DisplayName("Should return must not exceed x characters")
        void ShouldReturnproductMustNotExceedxChar() throws Exception {
            var productRequest = validPaylaod();
            productRequest.put("sku", EXCEED_LIMIT);
            productRequest.put("name", EXCEED_LIMIT);
            productRequest.put("category",EXCEED_LIMIT);
            productRequest.put("brand", EXCEED_LIMIT);
            productRequest.put("barCode", EXCEED_LIMIT);

            postProduct(productRequest)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors[?(@.field == 'sku')].message")
                    .value("SKU must not exceed 50 characters."))
                .andExpect(jsonPath("$.errors[?(@.field == 'category')].message")
                    .value("Category must not exceed 100 characters"))
                .andExpect(jsonPath("$.errors[?(@.field == 'brand')].message")
                    .value("Brand must not exceed 100 characters"))
                .andExpect(jsonPath("$.errors[?(@.field == 'barCode')].message")
                    .value("Barcode must not exceed 50 characters."))
                .andExpect(jsonPath("$.errors[?(@.field == 'name')].message")
                        .value("Product name must not exceed 150 characters."));

            then(productManagementInputPort).shouldHaveNoInteractions();
        }

        @Test
        @DisplayName("The provided value has an invalid precision.")
        void ShouldReturnInvalidPrecision() throws Exception {
            var productRequest = validPaylaod();
            productRequest.put("costPrice", new BigDecimal("1.000"));
            productRequest.put("sellPrice", new BigDecimal("1.000"));
            productRequest.put("weight", new BigDecimal("1.00000"));

            postProduct(productRequest)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors[?(@.field == 'costPrice')].message")
                    .value("The provided value has an invalid precision."))
                .andExpect(jsonPath("$.errors[?(@.field == 'sellPrice')].message")
                    .value("The provided value has an invalid precision."))
                .andExpect(jsonPath("$.errors[?(@.field == 'weight')].message")
                    .value("The provided value has an invalid precision."));

            then(productManagementInputPort).shouldHaveNoInteractions();
        }

        @Test
        @DisplayName("Should return Sell price cannot be lower than cost price")
        void ShouldReturnSellPriceCannotbeLower() throws Exception {
            var productRequest = validPaylaod();
            productRequest.put("costPrice", new BigDecimal("1000"));
            productRequest.put("sellPrice", new BigDecimal("500"));

            postProduct(productRequest)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors[?(@.field == 'costPrice')].message")
                    .value("Sell price cannot be lower than cost price."));

            then(productManagementInputPort).shouldHaveNoInteractions();
        }

    }

    private ResultActions postProduct(Map<String, Object> payload) throws Exception {
        return mockMvc.perform(post("/product/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(payload)));
    }
}
