package com.skytouch.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.skytouch.repository.ProductRepository;
import com.skytouch.converter.JsonConverter;
import com.skytouch.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String getProducts() {
        return JsonConverter.objectToJson(productRepository.getProducts(), new ObjectMapper());
    }

    @Override
    public Boolean addProduct(Product product) {
        return productRepository.addProduct(product);
    }

}
