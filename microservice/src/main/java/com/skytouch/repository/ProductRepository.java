package com.skytouch.repository;

import com.skytouch.model.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Manage all crud Product Operations
 */
@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long>, ProductRepositoryCustom {
}

