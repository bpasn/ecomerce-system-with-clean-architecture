package com.app.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.domain.repositories.IProductRepository;
import com.app.infrastructure.entity.ProductEntity;


public interface ProductJpaRepository extends JpaRepository<ProductEntity,String> , IProductRepository {
    
}
