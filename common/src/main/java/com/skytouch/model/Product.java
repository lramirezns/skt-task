package com.skytouch.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "get_products",
                procedureName = "get_products",
                resultClasses = Product.class),
        @NamedStoredProcedureQuery(name = "insert_product",
                procedureName = "insert_product",
                resultClasses = {Product.class},
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "name", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "description", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "unit_price", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "quantity", type = Integer.class)
                }
        )
})
public class Product implements Serializable {

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

    public Product(String name, String description, Integer unitPrice, Integer quantiryPerUnit) {
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.quantiryPerUnit = quantiryPerUnit;
    }
    public Product(){}

    public Long getId() { return id; }

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


}
