package br.com.back.product.management.port.output;

import br.com.back.product.management.core.model.Product;

public interface ProductRepositoryOutputPort {

    void save(Product product);
}
