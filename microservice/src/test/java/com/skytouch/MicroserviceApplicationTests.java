package com.skytouch;


import com.skytouch.model.Product;
import com.skytouch.model.ProductEntity;
import com.skytouch.repository.ProductRepository;
import com.skytouch.service.ProductService;
import org.dozer.DozerBeanMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MicroserviceApplicationTests {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    private DozerBeanMapper mapper;
    private Product product;
    private ProductEntity productEntity;

    @Before
    public void setupData() {
        product = new Product("insertTest", "Unit Test", 1, 1);
        mapper = new DozerBeanMapper();
        productEntity = mapper.map(product, ProductEntity.class);


    }

    @Test
    public void getAllProducts() {
        List<ProductEntity> products = productRepository.getProducts();
        Assert.assertEquals(3, products.size());
    }

    @Test
    public void insertProduct() {
        Long id = productService.addProduct(product).longValue();
        ProductEntity result = productRepository.findOne(id);
        Assert.assertEquals(productEntity, result);
    }

    @After
    public void cleanSetupData() {
       productRepository.delete(productEntity);
    }

}
