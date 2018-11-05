package com.skytouch.service;

import com.skytouch.model.Product;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductMessageConsumerImpl implements ProductMessageConsumer {

    private final ProductService productService;

    private final String getProductsMessage;

    public ProductMessageConsumerImpl(ProductService productService, @Value("${product.rabbitmq.getProductsMessage}") String getProductsMessage) {
        this.productService = productService;
        this.getProductsMessage = getProductsMessage;
    }

    @Override
    @RabbitListener(queues = "${product.rabbitmq.insertQueue}", containerFactory = "productFactory")
    public Long receiveProduct(Product product) {
        return productService.addProduct(product);
    }

    @Override
    @RabbitListener(queues = "${product.rabbitmq.getProductsQueue}", containerFactory = "productFactory")
    public List<Product> getProducts(String message) {
        return getProductsMessage.equals(message) ? productService.getProducts() : null;
    }

}


