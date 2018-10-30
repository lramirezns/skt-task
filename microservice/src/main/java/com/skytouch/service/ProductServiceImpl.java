package com.skytouch.service;


import com.skytouch.common.model.Product;
import com.skytouch.model.ProductEntity;
import com.skytouch.repository.ProductRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final DozerBeanMapper mapper;


    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.mapper = new DozerBeanMapper();
    }

    @Override
    public List<Product> getProducts() {
        List<Product> result =
                productRepository.getProducts().stream().map(prod -> mapper.map(prod, Product.class)).collect(Collectors.toList());
        return result;
    }

    @Override
    public Long addProduct(Product product) {
        return productRepository.addProduct(mapper.map(product, ProductEntity.class));
    }

}
