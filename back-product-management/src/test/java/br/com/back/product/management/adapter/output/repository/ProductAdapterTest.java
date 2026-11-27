package br.com.back.product.management.adapter.output.repository;


import br.com.back.product.management.adapter.output.mapper.ProductRepositoryMapper;
import br.com.back.product.management.adapter.output.repository.entity.ProductEntity;
import br.com.back.product.management.core.exception.DuplicateSkuException;
import br.com.back.product.management.core.model.Product;
import br.com.back.product.management.port.output.LoggerOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import static br.com.back.product.management.factory.ProductFactory.createValidProductRequest;
import static br.com.back.product.management.factory.ProductFactory.toProduct;
import static br.com.back.product.management.factory.ProductFactory.toProductEntity;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.willThrow;

@ExtendWith(MockitoExtension.class)
@DisplayName("ProductAdapter")
public class ProductAdapterTest {

    @Mock
    private ProductRepository repository;

    @Mock
    private ProductRepositoryMapper mapper;

    @Mock
    private LoggerOutputPort logger;

    private ProductAdapter productAdapter;

    @BeforeEach
    public void setUp() {
        productAdapter = new ProductAdapter(repository, mapper, logger);
    }

    @Nested
    @DisplayName("Save Product")
    class SaveProduct {

        @Test
        @DisplayName("Should Save Product")
        public void shouldSaveProduct() {
            var product = toProduct(createValidProductRequest());
            var entity = toProductEntity(product);

            given(mapper.toEntity(product)).willReturn(entity);
            given(repository.save(any())).willReturn(entity);

            productAdapter.save(product);

            then(repository).should().save(entity);
        }

        @Test
        @DisplayName("Should Throw DuplicateSkuException")
        public void shouldThrowDuplicateSkuException() {
            var product = toProduct(createValidProductRequest());
            var entity = toProductEntity(product);
            given(mapper.toEntity(any(Product.class))).willReturn(new ProductEntity());
            willThrow(new DataIntegrityViolationException(entity.getSku()))
                    .given(repository).save(any(ProductEntity.class));

            assertThrows(DuplicateSkuException.class,
                    () -> productAdapter.save(product));
        }
    }
}
