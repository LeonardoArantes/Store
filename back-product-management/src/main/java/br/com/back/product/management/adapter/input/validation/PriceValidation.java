package br.com.back.product.management.adapter.input.validation;

import br.com.back.product.management.adapter.input.controller.dto.request.ProductRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PriceValidation implements ConstraintValidator<ValidPrices, ProductRequest> {
    @Override
    public void initialize(ValidPrices constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(ProductRequest product, ConstraintValidatorContext context) {
        if  (product == null ||
            product.costPrice() == null ||
            product.sellPrice() == null) {
                return true;
        }

        boolean valid = product.sellPrice().compareTo(product.sellPrice()) >= 0;

        if(!valid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("costPrice")
                    .addConstraintViolation();
        }

        return valid;
    }
}
