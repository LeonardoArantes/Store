package br.com.back.product.management.adapter.input.controller.Swagger;

public final class ProductExamples {

    public ProductExamples() {
    }

    public static final String CREATE_REQUEST = """
        {
          "sku": "925192",
          "nome": "air intake",
          "description": "AFE brand air intake with a SATin finish, fitting a 5.4L engine, with internal stock number 1283, stored in section E",
          "category": "Automotive parts",
          "brand": "aFe",
          "barCode": "0912837912398",
          "costPrice": 445.99,
          "sellPrice": 500.99,
          "weight": 4.159
        }
        """;

    public static final String CREATE_RESPONSE = """
        {
            "code": "0001",
            "message": "Product Created"
        }
        """;

    public static final String VALIDATION_ERROR = """
        {
             "errors": [
                 {
                     "field": "sku",
                     "message": "SKU is required."
                 },
                 {
                     "field": "nome",
                     "message": "Product name is required."
                 },
                 {
                     "field": "costPrice",
                     "message": "Cost price is required."
                 },
                 {
                     "field": "sellPrice",
                     "message": "Sell price is required."
                 },
                 {
                     "field": "weight",
                     "message": "Product weight is required."
                 }
             ]
         }
        """;

    public static final String DUPLICATE_SKU = """
        {
             "field": "sku",
             "message": "SKU already exists."
        }
        """;
}
