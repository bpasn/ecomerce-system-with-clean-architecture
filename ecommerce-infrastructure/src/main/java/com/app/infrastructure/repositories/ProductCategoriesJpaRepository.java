package com.app.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.domain.entity.ProductCategoriesEntity;
import com.app.domain.repositories.IProductCategoriesRepository;

public interface ProductCategoriesJpaRepository extends JpaRepository<ProductCategoriesEntity,String> , IProductCategoriesRepository {
    boolean existsByName(String name);
}
