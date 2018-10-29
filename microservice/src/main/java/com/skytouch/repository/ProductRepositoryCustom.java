package com.skytouch.repository;

import java.util.List;
import com.skytouch.model.Product;

public interface ProductRepositoryCustom {

    List<Product> getProducts();

    Boolean addProduct(Product product);
}
