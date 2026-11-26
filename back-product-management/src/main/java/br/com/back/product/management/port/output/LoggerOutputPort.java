package br.com.back.product.management.port.output;

public interface LoggerOutputPort {

    void info(String message, Object... args);

    void warn(String message, Object... args);

    void error(String message, Object... args);

}
