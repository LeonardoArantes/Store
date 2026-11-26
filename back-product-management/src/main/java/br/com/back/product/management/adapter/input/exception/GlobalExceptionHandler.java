package br.com.back.product.management.adapter.input.exception;

import br.com.back.product.management.adapter.input.controller.dto.response.errorResponse.ErrorResponse;
import br.com.back.product.management.adapter.input.controller.dto.response.errorResponse.Errors;
import br.com.back.product.management.port.output.LoggerOutputPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final LoggerOutputPort logger;

    public GlobalExceptionHandler(LoggerOutputPort logger) {
        this.logger = logger;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException exception) {

        List<Errors> erros = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> new Errors(
                        fieldError.getField(),
                        fieldError.getDefaultMessage()
                ))
                .toList();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(erros));
    }
}
