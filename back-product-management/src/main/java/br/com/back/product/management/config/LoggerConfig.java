package br.com.back.product.management.config;

import br.com.back.product.management.adapter.output.logger.LoggerAdapter;
import br.com.back.product.management.port.output.LoggerOutputPort;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class LoggerConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public LoggerOutputPort loggerOutputPort(InjectionPoint injectionPoint) {
        Class<?> clazz = injectionPoint.getMember().getDeclaringClass();
        return new LoggerAdapter(clazz);
    }

}
