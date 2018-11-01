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
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "unit_price")
    private long unitPrice;

    @Column(name = "quantity_per_unit")
    private int quantityPerUnit;

    public ProductEntity(String name, String description, long unitPrice, int quantiryPerUnit) {
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.quantityPerUnit = quantiryPerUnit;
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

    public long getUnitPrice() {
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

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setQuantityPerUnit(int quantiryPerUnit) {
        this.quantityPerUnit = quantiryPerUnit;
    }

}
