package com.skytouch.repository;

import com.skytouch.model.ProductEntity;

import java.util.List;

/**
 * Manage Product stored procedures
 */
public interface ProductRepositoryCustom {

    /**
     * Obtains all products from the database calling the store procedure get_products
     *
     * @return List of products
     */
    List<ProductEntity> getProducts();

    /**
     * Calls store procedure insert_product and inserts a product in the database.
     *
     * @param product
     * @return the id of this created product.
     */

    Long addProduct(ProductEntity product);
}
