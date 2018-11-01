package com.skytouch.service;

import com.skytouch.model.Product;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductMessageConsumerImpl implements ProductMessageConsumer {

    ProductService productService;

    @Value("${product.rabbitmq.getProductsMessage}")
    private String getProductsMessage;

    public ProductMessageConsumerImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    @RabbitListener(queues = "${product.rabbitmq.insertQueue}", containerFactory = "productFactory")
    public Long receiveProduct(Product product) {
        return productService.addProduct(product);
    }

    @Override
    @RabbitListener(queues = "${product.rabbitmq.getProductsQueue}", containerFactory = "productFactory")
    public List<Product> getProducts(String message) {
        if (getProductsMessage.equals(message)) {
            return productService.getProducts();
        }
        return null;
    }

}


