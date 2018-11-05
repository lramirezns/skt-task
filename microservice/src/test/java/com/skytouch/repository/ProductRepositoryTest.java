package com.skytouch.repository;

import com.skytouch.model.ProductEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;


@Transactional
@Rollback
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;
    private ProductEntity productEntity;

    @Before
    public void setupData() {
        productEntity = new ProductEntity("insertTest", "Unit Test", 1D, 1);
    }

    @Test
    public void getAllProductsTest() {
        ProductEntity firstRow = new ProductEntity("Keyboard", "Razer Keyboard", 50D, 2);
        ProductEntity secondRow = new ProductEntity("Mouse", "Microsoft Mouse", 20D, 6);
        ProductEntity thirdRow = new ProductEntity("Micro", "Microsoft micfrophone", 3D, 4);
        List<ProductEntity> expectedResult = new ArrayList<>();
        expectedResult.add(firstRow);
        expectedResult.add(secondRow);
        expectedResult.add(thirdRow);
        List<ProductEntity> products = productRepository.getProducts();
        Assert.assertThat(products, is(expectedResult));
    }

    @Test
    public void insertProduct() {
        Long id = productRepository.addProduct(productEntity);
        ProductEntity result = productRepository.findOne(id);
        Assert.assertEquals(productEntity, result);
    }
}
