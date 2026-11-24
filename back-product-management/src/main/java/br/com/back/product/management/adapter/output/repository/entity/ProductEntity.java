package br.com.back.product.management.adapter.output.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, unique = true, length = 50)
    String sku;

    @Column(nullable = false, length = 150)
    String nome;

    String description;

    String category;

    String brand;

    @Column(name = "bar_code", length = 50)
    String barCode;

    @Column(name = "cost_price", nullable = false, precision = 12, scale = 2)
    BigDecimal costPrice;

    @Column(name = "sell_price", nullable = false, precision = 12, scale = 2)
    BigDecimal sellPrice;

    @Column(name = "measurement_unit", nullable = false, length = 20)
    Integer weight;


    public ProductEntity() {
    }

    public ProductEntity(String sku, String nome, String description, String category, String brand, String barCode, BigDecimal costPrice, BigDecimal sellPrice, Integer weight) {
        this.sku = sku;
        this.nome = nome;
        this.description = description;
        this.category = category;
        this.brand = brand;
        this.barCode = barCode;
        this.costPrice = costPrice;
        this.sellPrice = sellPrice;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
