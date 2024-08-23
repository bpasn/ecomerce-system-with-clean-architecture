package com.app.infrastructure.repositories;

import com.app.domain.entity.ProductEntity;
import com.app.domain.repositories.IProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductJpaRepository extends JpaRepository<ProductEntity,Long> , IProductRepository {
}
