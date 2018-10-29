package com.skytouch.service;



import com.skytouch.model.Product;

public interface ProductService {

    String getProducts();

    Boolean addProduct(Product product);
}
