package br.com.back.product.management.port.input;

import br.com.back.product.management.core.model.Product;

public interface ProductManagementInputPort {

    void createProduct(Product product);
}
