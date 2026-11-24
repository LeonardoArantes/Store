package br.com.back.product.management.adapter.output.repository;

import br.com.back.product.management.adapter.output.repository.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {


}
