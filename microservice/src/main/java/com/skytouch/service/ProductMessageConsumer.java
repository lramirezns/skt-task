package com.skytouch.service;

import com.skytouch.model.Product;

import java.util.List;

public interface ProductMessageConsumer {
    public Long receiveProduct(Product product);

    public List<Product> getProducts(String message);
}
