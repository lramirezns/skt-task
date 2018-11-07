package com.skytouch.service;


import com.skytouch.model.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductMessageSenderTest {

    @Test
    public void testGetProducts() {
        final String productName = "insertTest";
        List<Product> productList = Collections.singletonList(new Product
                (productName, "Unit Test", new BigDecimal("1.5"), 1));
        AmqpTemplate template = mock(AmqpTemplate.class);
        when(template.convertSendAndReceive("getProducts")).thenReturn(productList);
        Assert.assertEquals(productName, productList.get(0).getName());

    }
}
