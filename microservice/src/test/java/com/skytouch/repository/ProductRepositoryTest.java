package com.skytouch.repository;

import com.skytouch.model.ProductEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void getAllProductsTest() {
        ProductEntity firstRow = new ProductEntity("Keyboard", "Razer Keyboard", new BigDecimal("50"), 2);
        ProductEntity secondRow = new ProductEntity("Mouse", "Microsoft Mouse", new BigDecimal("20"), 6);
        ProductEntity thirdRow = new ProductEntity("Micro", "Microsoft micfrophone", new BigDecimal("3"), 4);
        List<ProductEntity> expectedResult = new ArrayList<>();
        expectedResult.add(firstRow);
        expectedResult.add(secondRow);
        expectedResult.add(thirdRow);
        List<ProductEntity> products = productRepository.getProducts();
        Assert.assertThat(products, is(expectedResult));
    }

    @Transactional
    @Test
    public void insertProduct() {
        ProductEntity productEntity = new ProductEntity("repositoryTest", "Unit Test", new BigDecimal("1.5"), 35);
        Long id = productRepository.addProduct(productEntity);
        ProductEntity result = productRepository.findOne(id);
        Assert.assertEquals(productEntity, result);
    }
}
