package com.skytouch.repository;

import com.skytouch.model.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>, ProductRepositoryCustom{
}

