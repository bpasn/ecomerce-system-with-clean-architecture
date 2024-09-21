package com.app.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.domain.repositories.IProductCategoriesRepository;
import com.app.infrastructure.entity.ProductCategoriesEntity;

public interface ProductCategoriesJpaRepository extends JpaRepository<ProductCategoriesEntity,String> , IProductCategoriesRepository {
    boolean existsByName(String name);
}
