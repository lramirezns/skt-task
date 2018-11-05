package com.skytouch.service;

import com.skytouch.model.MessageServiceConfig;
import com.skytouch.model.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductMessageSenderTest {
    private MessageServiceConfig messageServiceConfig;

    @Before
    public void setupData() {
        messageServiceConfig = new MessageServiceConfig("product-exchange", "insertRoutingkey",
                "getProductsExchange", "getProductsRoutingkey", "getProductsQueue",
                "getProducts");
    }

    @Test
    public void testGetProducts() {
        List<Product> productList = Collections.singletonList(new Product
                ("insertTest", "Unit Test", 1D, 1));
        AmqpTemplate template = mock(AmqpTemplate.class);
        when(template.convertSendAndReceive(messageServiceConfig.getProductsMessage())).thenReturn(productList);

    }
}
