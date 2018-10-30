package com.skytouch.common.model;

import java.io.Serializable;
import java.util.Objects;


public class Product implements Serializable {


    private Long id;

    private String name;

    private String description;

    private Integer unitPrice;

    private Integer quantityPerUnit;

    public Product(String name, String description, Integer unitPrice, Integer quantityPerUnit) {
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.quantityPerUnit = quantityPerUnit;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public Integer getQuantiryPerUnit() {
        return quantityPerUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(unitPrice, product.unitPrice) &&
                Objects.equals(quantityPerUnit, product.quantityPerUnit);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, description, unitPrice, quantityPerUnit);
    }
}
