package com.skytouch.model;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
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
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_unit_price", type = BigDecimal.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_quantity", type = Integer.class)
                }
        )
})
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "quantity_per_unit")
    private int quantityPerUnit;

    public ProductEntity(String name, String description, BigDecimal unitPrice, int quantityPerUnit) {
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.quantityPerUnit = quantityPerUnit;
    }

    public ProductEntity() {
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

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public int getQuantityPerUnit() {
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

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setQuantityPerUnit(int quantiryPerUnit) {
        this.quantityPerUnit = quantiryPerUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductEntity)) return false;
        ProductEntity that = (ProductEntity) o;
        return quantityPerUnit == that.quantityPerUnit &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(unitPrice, that.unitPrice);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, description, unitPrice, quantityPerUnit);
    }
}
