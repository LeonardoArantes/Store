package br.com.back.product.management.core.usecase;

import br.com.back.product.management.adapter.input.controller.dto.response.ProductResponse;
import br.com.back.product.management.core.model.Product;
import br.com.back.product.management.port.input.ProductManagementInputPort;
import br.com.back.product.management.port.output.LoggerOutputPort;
import br.com.back.product.management.port.output.ProductRepositoryOutputPort;

public class ProductManagementUsecase implements ProductManagementInputPort {

    private final ProductRepositoryOutputPort repository;
    private final LoggerOutputPort logger;

    public ProductManagementUsecase(ProductRepositoryOutputPort repository, LoggerOutputPort logger) {
        this.repository = repository;
        this.logger = logger;
    }


    @Override
    public ProductResponse createProduct(Product product) {
        logger.info(String.format("Creating product %s", product.getNome()));
        repository.save(product);
        return null;
    }
}
