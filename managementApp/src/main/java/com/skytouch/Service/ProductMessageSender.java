package com.skytouch.Service;


import com.skytouch.model.Product;

import java.util.List;

public interface ProductMessageSender {

    Long insertProduct(Product product);

    List<Product> getProducts();
}
