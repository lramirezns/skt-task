package com.skytouch.service;

import com.skytouch.model.Product;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ProductMessageSenderImpl implements ProductMessageSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${product.rabbitmq.insertExchange}")
    private String insertExchange;

    @Value("${product.rabbitmq.insertRoutingkey}")
    private String insertRoutingkey;

    @Value("${product.rabbitmq.getProductsExchange}")
    private String getProductsExchange;

    @Value("${product.rabbitmq.getProductsRoutingkey}")
    private String getProductsRoutingkey;

    @Value("${product.rabbitmq.getProductsMessage}")
    private String getProductsMessage;

    @Override
    public void insertProduct(Product product) {
        Long id = (Long) amqpTemplate.convertSendAndReceive(insertExchange, insertRoutingkey, product);
        if (id == 0){
            throw new RuntimeException();
        }
    }

    @Override
    public List<Product> getProducts() {
        List<Product> productList = (List<Product>) amqpTemplate.convertSendAndReceive(getProductsExchange,
                getProductsRoutingkey, getProductsMessage);
        return productList;
    }
}
