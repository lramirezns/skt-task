package com.skytouch.service;

import com.skytouch.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductMessageConsumerTest {

    private Product product;
    private ProductMessageConsumer consumer;
    private final long ID = 13L;
    private ProductService productService;
    private String getProductsMessage;

    @Before
    public void setupData() {
        product = new Product("insertTest", "Unit Test", 1D, 1);
        getProductsMessage = "getProducts";
        productService = mock(ProductService.class);
        when(productService.addProduct(product)).thenReturn(ID);
        List<Product> productList = Collections.singletonList(new Product
                ("insertTest", "Unit Test", 1D, 1));
        when(productService.getProducts()).thenReturn(productList);
        consumer = new ProductMessageConsumerImpl(productService, getProductsMessage);
    }

    @Test
    public void testReceiveProduct() {
        long result = consumer.receiveProduct(product);
        Assert.assertEquals(ID, result);
    }

    @Test
    public void testGetProductsWithValidMessage() {
        String message = "getProducts";
        List<Product> result = consumer.getProducts(message);
        Assert.assertEquals(product, result.get(0));
    }

    @Test
    public void testProductsWithInvalidMessage() {
        String message = "invalidMessage";
        List<Product> result = consumer.getProducts(message);
        Assert.assertNull(result);
    }
}
