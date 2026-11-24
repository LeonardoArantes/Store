package br.com.back.product.management.config;

import br.com.back.product.management.core.usecase.ProductManagementUsecase;
import br.com.back.product.management.port.input.ProductManagementInputPort;
import br.com.back.product.management.port.output.LoggerOutputPort;
import br.com.back.product.management.port.output.ProductRepositoryOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ProductManagementInputPort productManagementinputPort(
            ProductRepositoryOutputPort repository,
            LoggerOutputPort logger
    ) {
        return new ProductManagementUsecase(repository, logger);
    }
}
