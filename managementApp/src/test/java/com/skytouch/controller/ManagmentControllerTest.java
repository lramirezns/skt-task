package com.skytouch.controller;

import com.skytouch.model.Product;
import com.skytouch.service.ProductMessageSender;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagmentControllerTest {

    @Test
    public void testProductsTestViewName() {
        List<Product> productList;
        productList = Collections.singletonList(new Product
                ("testGetProducts", "Unit Test", new BigDecimal("1.5"), 1));
        ProductMessageSender messageSender = mock(ProductMessageSender.class);
        when(messageSender.getProducts()).thenReturn(productList);
        ManagmentController controller = new ManagmentController(messageSender);
        ModelMap modelMap = new ModelMap();
        ModelAndView mav = controller.products(modelMap);
        Assert.assertEquals("products", mav.getViewName());
    }

    @Test
    public void testProduct() {
        ProductMessageSender messageSender = mock(ProductMessageSender.class);
        ManagmentController controller = new ManagmentController(messageSender);
        ModelAndView mav = controller.product();
        Assert.assertEquals("product", mav.getViewName());
    }

    @Test
    public void testAddProduct() {
        Product product = new Product("MessageConsumerTest", "Unit Test", new BigDecimal("1.5"), 7);
        ProductMessageSender messageSender = mock(ProductMessageSender.class);
        ManagmentController controller = new ManagmentController(messageSender);
        ModelMap modelMap = new ModelMap();
        String result = controller.addProduct(product, modelMap);
        Assert.assertEquals("redirect:/product", result);
    }
}
