package com.skytouch.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.Objects;


@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Product.class)
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

    public Integer getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public Integer setQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setQuantityPerUnit(Integer quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
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
