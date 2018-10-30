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
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "name", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "description", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "unit_price", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "quantity", type = Integer.class)
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
    private Integer quantiryPerUnit;

    public ProductEntity(String name, String description, Integer unitPrice, Integer quantiryPerUnit) {
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.quantiryPerUnit = quantiryPerUnit;
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

    public Integer getQuantiryPerUnit() {
        return quantiryPerUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductEntity)) return false;
        ProductEntity product = (ProductEntity) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(unitPrice, product.unitPrice) &&
                Objects.equals(quantiryPerUnit, product.quantiryPerUnit);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, description, unitPrice, quantiryPerUnit);
    }
}
