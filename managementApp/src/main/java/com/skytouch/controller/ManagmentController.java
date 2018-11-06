package com.skytouch.controller;

import com.skytouch.model.Product;
import com.skytouch.service.ProductMessageSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ManagmentController {
    private ProductMessageSender productMessageSender;

    public ManagmentController(ProductMessageSender managmentService) {
        this.productMessageSender = managmentService;
    }

    @GetMapping("/product")
    public ModelAndView product() {
        return new ModelAndView("product", "product", new Product());

    }

    @GetMapping("/products")
    public ModelAndView products(ModelMap model) {
        model.addAttribute("products", productMessageSender.getProducts());
        return new ModelAndView("products");

    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("product") Product product, ModelMap model) {
        productMessageSender.insertProduct(product);
        return "redirect:/product";
    }


}