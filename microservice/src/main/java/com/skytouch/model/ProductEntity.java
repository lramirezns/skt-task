package com.skytouch.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "product")

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "get_products",
                procedureName = "get_products",
                resultClasses = ProductEntity.class),
        @NamedStoredProcedureQuery(name = "insert_product",
                procedureName = "insert_product",
                resultClasses = {ProductEntity.class},
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_name", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_description", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_unit_price", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_quantity", type = Integer.class)
                }
        )
})
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "unit_price")
    private Integer unitPrice;

    @Column(name = "quantity_per_unit")
    private Integer quantityPerUnit;

    public ProductEntity(String name, String description, Integer unitPrice, Integer quantiryPerUnit) {
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.quantityPerUnit = quantiryPerUnit;
    }

    public ProductEntity() {
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

    public void setQuantityPerUnit(Integer quantiryPerUnit) {
        this.quantityPerUnit = quantiryPerUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductEntity)) return false;
        ProductEntity product = (ProductEntity) o;
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
