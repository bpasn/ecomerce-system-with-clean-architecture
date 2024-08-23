package com.app.infrastructure.repositories;

import com.app.domain.entity.ProductImageEntity;
import com.app.domain.repositories.IProductImageRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageJpaRepository extends JpaRepository<ProductImageEntity,Long>, IProductImageRepository {
}
