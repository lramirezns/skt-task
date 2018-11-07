package com.skytouch.service;


import com.skytouch.model.Product;

import java.util.List;

/**
 * Manage all product Services
 */
public interface ProductService {
    /**
     * Obtains all products from the database
     *
     * @return List of products
     */

    List<Product> getProducts();

    /**
     * Inserts a product in the database.
     *
     * @param product
     * @return the id of this created product.
     */
    Long addProduct(Product product);
}
