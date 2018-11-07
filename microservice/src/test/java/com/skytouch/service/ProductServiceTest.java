package com.skytouch.service;

import com.skytouch.model.Product;
import com.skytouch.model.ProductEntity;
import com.skytouch.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Test
    public void testGetAllProductList() {
        Product product=  new Product("testGetAllProductList", "Unit Test", new BigDecimal("2.5"), 2);
        List<ProductEntity> productList = Collections.singletonList(new ProductEntity
                ("testGetAllProductList", "Unit Test", new BigDecimal("2.5"), 2));
        ProductRepository mockRepository = mock(ProductRepository.class);
        when(mockRepository.getProducts()).thenReturn(productList);
        ProductService productService = new ProductServiceImpl(mockRepository);
        Assert.assertEquals(product, productService.getProducts().get(0));
    }

    @Test
    public void testInsertProduct() {
        Product product = new Product("ProductServiceTest", "Unit Test", new BigDecimal("1.5"), 1);
        final long id = 13L;
        ProductEntity productEntity = new ProductEntity("ProductServiceTest", "Unit Test", new BigDecimal("1.5"), 1);
        ProductRepository mockRepository = mock(ProductRepository.class);
        when(mockRepository.addProduct(productEntity)).thenReturn(id);
        ProductService productService = new ProductServiceImpl(mockRepository);
        long result = productService.addProduct(product);
        Assert.assertEquals(id, result);
    }


}
