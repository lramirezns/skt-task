package com.skytouch.repository;

import com.skytouch.model.ProductEntity;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Manage all crud Product Operations
 */
@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long>, ProductRepositoryCustom{
}

