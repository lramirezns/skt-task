package com.skytouch.repository;

import com.skytouch.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepositoryCustom {

    private final EntityManager entityManager;


    public ProductRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Product> getProducts() {
        StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("get_products");
        return storedProcedure.getResultList();
    }

    @Override
    public Boolean addProduct(Product product) {
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("insert_product");

            storedProcedure
                    .setParameter("name", product.getName())
                    .setParameter("description", product.getDescription())
                    .setParameter("unit_price", product.getUnitPrice())
                    .setParameter("quantity", product.getQuantiryPerUnit());

            storedProcedure.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
