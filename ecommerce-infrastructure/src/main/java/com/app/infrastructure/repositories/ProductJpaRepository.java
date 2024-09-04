package com.app.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.domain.entity.ProductEntity;
import com.app.domain.repositories.IProductRepository;


public interface ProductJpaRepository extends JpaRepository<ProductEntity,String> , IProductRepository {
    
}
