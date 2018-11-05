package com.skytouch.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.Objects;


@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Product.class)
public class Product implements Serializable {


    private long id;

    private String name;

    private String description;

    private double unitPrice;

    private int quantityPerUnit;

    public Product(String name, String description, double unitPrice, int quantityPerUnit) {
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.quantityPerUnit = quantityPerUnit;
    }

    public Product() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public int setQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setQuantityPerUnit(int quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Double.compare(product.unitPrice, unitPrice) == 0 &&
                quantityPerUnit == product.quantityPerUnit &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, description, unitPrice, quantityPerUnit);
    }
}
