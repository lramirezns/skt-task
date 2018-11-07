package com.skytouch.repository;

import com.skytouch.model.ProductEntity;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

class ProductRepositoryImpl implements ProductRepositoryCustom {

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
                .setParameter("p_name", product.getName())
                .setParameter("p_description", product.getDescription())
                .setParameter("p_unit_price", product.getUnitPrice())
                .setParameter("p_quantity", product.getQuantityPerUnit());

        ProductEntity result = (ProductEntity) storedProcedure.getSingleResult();
        return result.getId();
    }
}
