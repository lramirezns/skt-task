package com.skytouch;
import com.skytouch.repository.ProductRepository;
import com.skytouch.service.ProductService;
import com.skytouch.model.Product;
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
private ProductService _productService;
@Autowired private ProductRepository _productRepository;

private Product product;

	@Before
	public void setupData(){
		product = new Product("insertTest", "Unit Test", 1,1);
	}

	@Test
	public void getAllProducts() {
		List<Product> products = _productRepository.getProducts();
		Assert.assertEquals(3,products.size());
	}

	@Test
	public void insertProduct(){
		Assert.assertEquals(true,_productService.addProduct(product));
	}

	@After
	public void cleanSetupData(){
		_productRepository.delete(product);
	}

}
