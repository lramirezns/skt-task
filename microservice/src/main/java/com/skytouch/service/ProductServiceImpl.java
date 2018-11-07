package com.skytouch.service;


import com.skytouch.model.Product;
import com.skytouch.model.ProductEntity;
import com.skytouch.repository.ProductRepository;
import com.skytouch.utility.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> result =
                productRepository.getProducts().stream().map(prod -> Mapper.mapObject
                        (prod, Product.class)).collect(Collectors.toList());
        return result;
    }

    @Override
    public Long addProduct(Product product) {
        return productRepository.addProduct(Mapper.mapObject(product, ProductEntity.class));
    }

}
