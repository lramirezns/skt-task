package com.skytouch.service;

import com.skytouch.model.Product;

import java.util.List;

/**
 * This interface handles the messages configured by rabbitMQ
 */

public interface ProductMessageConsumer {

    /**
     * Receives a message as object product and inserts it into the database
     * @param product
     * @return the id of this created product.
     */
    public Long receiveProduct(Product product);

    /**
     * Recives and validates a message, if is valid, return all de products from the database.
     * @param message
     * @return all the products from the database
     */
    public List<Product> getProducts(String message);
}
