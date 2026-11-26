package br.com.back.product.management.adapter.output.logger;

import br.com.back.product.management.port.output.LoggerOutputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class LoggerAdapter implements LoggerOutputPort {

    private final Logger logger;
    private final String origin;

    public LoggerAdapter(Class<?> clazz) {
        this.logger = LoggerFactory.getLogger(clazz);
        this.origin = clazz.getSimpleName();
    }

    @Override
    public void info(String message, Object... args) {
        logger.info(message, args);
    }

    @Override
    public void warn(String message, Object... args) {
        logger.warn(message, args);
    }

    @Override
    public void error(String message, Object... args) {
        logger.error(message, args);;
    }

    @Override
    public void error(String message, Throwable throwable, Object... args) {
        Object[] all = Arrays.copyOf(args, args.length + 1);
        all[args.length] = throwable;
        logger.error(message, all);
    }

    private static Object[] prepend(Object first, Object[] rest){
        Object[] result = new Object[rest.length + 1];
        result[0] = first;
        System.arraycopy(rest, 0, result, 1, rest.length);
        return result;
    }
}
