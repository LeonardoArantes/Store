package br.com.back.product.management.core.model;

import java.math.BigDecimal;

public class Product {

    private String SKU;
    private String nome;
    private String description;
    private String categoria;
    private String brand;
    private String barCode;
    private BigDecimal costPrice;
    private BigDecimal sellPrice;
    private BigDecimal weight;

    public Product(Builder builder) {
        this.SKU = builder.SKU;
        this.nome = builder.nome;
        this.description = builder.description;
        this.categoria = builder.categoria;
        this.brand = builder.brand;
        this.barCode = builder.barCode;
        this.costPrice = builder.costPrice;
        this.sellPrice = builder.sellPrice;
        this.weight = builder.weight;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public static class Builder {
        private String SKU;
        private String nome;
        private String description;
        private String categoria;
        private String brand;
        private String barCode;
        private BigDecimal costPrice;
        private BigDecimal sellPrice;
        private BigDecimal weight;

        public Builder() {
        }

        public Builder SKU(String SKU) {
            this.SKU = SKU;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder categoria(String categoria) {
            this.categoria = categoria;
            return this;
        }

        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder barCode(String barCode) {
            this.barCode = barCode;
            return this;
        }

        public Builder costPrice(BigDecimal costPrice) {
            this.costPrice = costPrice;
            return this;
        }

        public Builder sellPrice(BigDecimal sellPrice) {
            this.sellPrice = sellPrice;
            return this;
        }

        public Builder weight(BigDecimal weight) {
            this.weight = weight;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
