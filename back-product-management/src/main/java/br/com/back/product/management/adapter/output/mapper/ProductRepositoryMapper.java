package br.com.back.product.management.adapter.output.mapper;

import br.com.back.product.management.adapter.output.repository.entity.ProductEntity;
import br.com.back.product.management.core.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductRepositoryMapper {

    public ProductEntity toEntity(Product product) {
        return new ProductEntity(
            product.getSKU(),
            product.getNome(),
            product.getDescription(),
            product.getCategoria(),
            product.getBrand(),
            product.getBarCode(),
            product.getCostPrice(),
            product.getSellPrice(),
            product.getMeasurementUnit()
        );
    }

}
