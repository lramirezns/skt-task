package com.skytouch.controller;


import com.skytouch.service.ProductService;
import com.skytouch.common.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(name = "/insertProduct", method = RequestMethod.PUT)
    @ResponseBody
    public Long insertProduct(
            @RequestParam("product") Product product) {
        return productService.addProduct(product);
    }


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getProducts() {
        return productService.getProducts();

    }

}
