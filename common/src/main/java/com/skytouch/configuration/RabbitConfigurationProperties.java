package com.skytouch.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "product.rabbitmq")
 final class RabbitConfigurationProperties {

    private String insertExchange;
    private String insertQueue;
    private String insertRoutingkey;
    private String getProductsExchange;
    private String getProductsQueue;
    private String getProductsRoutingkey;

    public String getInsertExchange() {
        return insertExchange;
    }

    public void setInsertExchange(String insertExchange) {
        this.insertExchange = insertExchange;
    }

    public String getInsertQueue() {
        return insertQueue;
    }

    public void setInsertQueue(String insertQueue) {
        this.insertQueue = insertQueue;
    }

    public String getInsertRoutingkey() {
        return insertRoutingkey;
    }

    public void setInsertRoutingkey(String insertRoutingkey) {
        this.insertRoutingkey = insertRoutingkey;
    }

    public String getGetProductsExchange() {
        return getProductsExchange;
    }

    public void setGetProductsExchange(String getProductsExchange) {
        this.getProductsExchange = getProductsExchange;
    }

    public String getGetProductsQueue() {
        return getProductsQueue;
    }

    public void setGetProductsQueue(String getProductsQueue) {
        this.getProductsQueue = getProductsQueue;
    }

    public String getGetProductsRoutingkey() {
        return getProductsRoutingkey;
    }

    public void setGetProductsRoutingkey(String getProductsRoutingkey) {
        this.getProductsRoutingkey = getProductsRoutingkey;
    }
}
