package br.com.back.product.management.adapter.output.repository;

import br.com.back.product.management.adapter.output.mapper.ProductRepositoryMapper;
import br.com.back.product.management.core.exception.DuplicateSkuException;
import br.com.back.product.management.core.model.Product;
import br.com.back.product.management.port.output.LoggerOutputPort;
import br.com.back.product.management.port.output.ProductRepositoryOutputPort;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

@Repository
public class ProductAdapter implements ProductRepositoryOutputPort {

    private final ProductRepository productRepository;
    private final ProductRepositoryMapper mapper;
    private final LoggerOutputPort logger;

    public ProductAdapter(ProductRepository productRepository, ProductRepositoryMapper mapper, LoggerOutputPort logger) {
        this.productRepository = productRepository;
        this.mapper = mapper;
        this.logger = logger;
    }

    @Override
    public void save(Product product) {
        try {
            logger.info("Saving product: {} on DB", product.getName());
            var entity = mapper.toEntity(product);
            productRepository.save(entity);
        } catch (DataIntegrityViolationException e) {
            logger.error("SKU [{}] already exists.", product.getSKU(),
                    e.getMessage());
            throw new DuplicateSkuException(product.getSKU());
        }
    }
}
