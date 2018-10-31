package com.skytouch.controller;


import com.skytouch.common.model.Product;
import com.skytouch.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PutMapping(name = "/insertProduct")
    @ResponseBody
    public Long insertProduct(
            @RequestParam("product") Product product) {
        return productService.addProduct(product);
    }


    @GetMapping(value = "/products")
    public List<Product> getProducts() {
        return productService.getProducts();

    }

}
