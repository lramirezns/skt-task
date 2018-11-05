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

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTests {


    private Product product;

    @Before
    public void setupData() {
        product = new Product("insertTest", "Unit Test", 1D, 1);
    }

    @Test
    public void testGetAllProductList() {
        List<ProductEntity> productList = Collections.singletonList(new ProductEntity
                ("insertTest", "Unit Test", 1D, 1));
        ProductRepository mockRepository = mock(ProductRepository.class);
        when(mockRepository.getProducts()).thenReturn(productList);
        ProductService productService = new ProductServiceImpl(mockRepository);
        Assert.assertEquals(product, productService.getProducts().get(0));
    }

    @Test
    public void testInsertProduct() {
        final long id = 13L;
        ProductEntity productEntity = new ProductEntity("insertTest", "Unit Test", 1D, 1);
        ProductRepository mockRepository = mock(ProductRepository.class);
        when(mockRepository.addProduct(productEntity)).thenReturn(id);
        ProductService productService = new ProductServiceImpl(mockRepository);
        long result = productService.addProduct(product);
        Assert.assertEquals(id, result);
    }


}
