package br.com.back.product.management.factory;

import br.com.back.product.management.adapter.input.controller.dto.request.ProductRequest;
import br.com.back.product.management.adapter.input.controller.mapper.ProductMapper;
import br.com.back.product.management.adapter.output.mapper.ProductRepositoryMapper;
import br.com.back.product.management.adapter.output.repository.entity.ProductEntity;
import br.com.back.product.management.core.model.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ProductFactory {

    public static Map<String, Object> validPaylaod() {
        var payload = new HashMap<String, Object>();
        payload.put("sku", "SKU-001");
        payload.put("nome", "Notebook");
        payload.put("description", "Notebook gamer");
        payload.put("category", "Eletrônicos");
        payload.put("brand", "Acme");
        payload.put("barCode", "7891234567890");
        payload.put("costPrice", 3200.00);
        payload.put("sellPrice", 4599.90);
        payload.put("weight", 1.850);
        return payload;
    }

    public static ProductRequest createValidProductRequest() {
        return new ProductRequest(
                "PROD-0002",
                "Notebook Dell Inspiron 17",
                "Notebook com processador Intel Core i5, 16GB RAM e SSD de 512GB.",
                "Informática",
                "Dell",
                "7891234567890",
                new BigDecimal("3200.00"),
                new BigDecimal("4599.90"),
                new BigDecimal("1.850"));
    }

    public static Product toProduct(ProductRequest productRequest) {
        return new ProductMapper().toDomain(productRequest);
    }

    public static ProductEntity toProductEntity(Product product) {
        return new ProductRepositoryMapper().toEntity(product);
    }

}
