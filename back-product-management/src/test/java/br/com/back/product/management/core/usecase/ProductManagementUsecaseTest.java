package br.com.back.product.management.core.usecase;

import br.com.back.product.management.core.exception.DuplicateSkuException;
import br.com.back.product.management.factory.ProductFactory;
import br.com.back.product.management.port.output.LoggerOutputPort;
import br.com.back.product.management.port.output.ProductRepositoryOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.willThrow;


@ExtendWith(MockitoExtension.class)
@DisplayName("ProductManagementUsecase")
public class ProductManagementUsecaseTest {

    @Mock
    private ProductRepositoryOutputPort repository;

    @Mock
    private LoggerOutputPort logger;

    private ProductManagementUsecase productManagementUsecase;

    @BeforeEach
    void setUp() {
        productManagementUsecase =
                new ProductManagementUsecase(repository, logger);
    }

    @Test
    @DisplayName("Should send product to repository")
    void shouldSendProductToRepository() {
        var productRequest = ProductFactory.createValidProductRequest();
        var product = ProductFactory.toProduct(productRequest);

        productManagementUsecase.createProduct(product);

        then(repository).should().save(product);
    }

    @Test
    @DisplayName("Should propagate error while saving product")
    void shouldPropagateErrorWhileSavingProduct () {
        var product = ProductFactory.toProduct(ProductFactory.createValidProductRequest());
        willThrow(new DuplicateSkuException(product.getSKU())).given(repository).save(product);

        assertThrows(DuplicateSkuException.class,
                () -> productManagementUsecase.createProduct(product));
    }

}
