package br.com.back.product.management.adapter.input.controller.mapper;

import br.com.back.product.management.adapter.input.controller.dto.request.ProductRequest;
import br.com.back.product.management.core.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toDomain(ProductRequest productRequest) {
        return new Product.Builder()
                    .SKU(productRequest.sku())
                    .nome(productRequest.nome())
                    .description(productRequest.description())
                    .categoria(productRequest.category())
                    .brand(productRequest.brand())
                    .barCode(productRequest.barCode())
                    .costPrice(productRequest.costPrice())
                    .sellPrice(productRequest.sellPrice())
                    .measurementUnit(productRequest.measurementUnit())
                .build();

    }
}
