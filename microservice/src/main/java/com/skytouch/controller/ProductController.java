package com.skytouch.controller;


import com.skytouch.service.ProductService;
import com.skytouch.model.Product;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(name = "/insertProduct", method = RequestMethod.PUT)
    @ResponseBody
    public Boolean insertProduct(
            @RequestParam("product") Product product) {
        return productService.addProduct(product);
    }


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getProducts() {
        return productService.getProducts();

    }

}
