package br.com.back.product.management.port.input;

import br.com.back.product.management.adapter.input.controller.dto.request.ProductRequest;
import br.com.back.product.management.adapter.input.controller.dto.response.ProductResponse;
import br.com.back.product.management.core.model.Product;

public interface ProductManagementInputPort {

    ProductResponse createProduct(Product product);
}
