package com.skytouch.service;


import com.skytouch.model.Product;

import java.util.List;

public interface ProductMessageSender {

    void insertProduct(Product product);

    List<Product> getProducts();
}
