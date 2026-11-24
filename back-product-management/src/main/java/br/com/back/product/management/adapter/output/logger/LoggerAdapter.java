package br.com.back.product.management.adapter.output.logger;

import br.com.back.product.management.port.output.LoggerOutputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggerAdapter implements LoggerOutputPort {

    private final Logger logger =
            LoggerFactory.getLogger(LoggerAdapter.class);

    @Override
    public void info(String message, Object... args) {
        logger.info(message);
    }

    @Override
    public void warn(String message, Object... args) {
        logger.warn(message);
    }

    @Override
    public void error(String message, Object... args) {
        logger.error(message);
    }
}
