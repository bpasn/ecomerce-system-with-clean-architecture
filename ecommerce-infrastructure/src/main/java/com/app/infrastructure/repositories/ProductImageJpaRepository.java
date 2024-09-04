package com.app.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.domain.entity.ProductImageEntity;
import com.app.domain.repositories.IProductImageRepository;

public interface ProductImageJpaRepository extends JpaRepository<ProductImageEntity,String>, IProductImageRepository {
}
