package com.skytouch.repository;

import com.skytouch.model.ProductEntity;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepositoryCustom {

    private final EntityManager entityManager;


    public ProductRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<ProductEntity> getProducts() {
        StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("get_products");
        return storedProcedure.getResultList();
    }

    @Override
    public Long addProduct(ProductEntity product) {
        StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("insert_product")
                .setParameter("name", product.getName())
                .setParameter("description", product.getDescription())
                .setParameter("unit_price", product.getUnitPrice())
                .setParameter("quantity", product.getQuantiryPerUnit());

        ProductEntity result = (ProductEntity) storedProcedure.getSingleResult();
        return result.getId();
    }
}
