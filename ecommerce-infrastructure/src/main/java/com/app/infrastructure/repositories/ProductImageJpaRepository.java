package com.app.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.domain.repositories.IProductImageRepository;
import com.app.infrastructure.entity.ProductImageEntity;

public interface ProductImageJpaRepository extends JpaRepository<ProductImageEntity,String>, IProductImageRepository {
}
