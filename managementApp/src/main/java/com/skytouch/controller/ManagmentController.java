package com.skytouch.controller;

import com.skytouch.Service.ProductMessageSender;
import com.skytouch.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManagmentController {

    private ProductMessageSender productMessageSender;


    public ManagmentController(ProductMessageSender managmentService) {
        this.productMessageSender = managmentService;
    }

    @GetMapping("/addProduct")
    public Long addProduct(@RequestParam("name") String name, @RequestParam("description") String description,
                           @RequestParam("unitPrice") Integer unitPrice, @RequestParam("quantity") Integer quantity) {

        Product product = new Product(name, description, unitPrice, quantity);
        return productMessageSender.insertProduct(product);
    }

    @GetMapping("/getProducts")
    public List<Product> getProducts() {
        return productMessageSender.getProducts();
    }

}