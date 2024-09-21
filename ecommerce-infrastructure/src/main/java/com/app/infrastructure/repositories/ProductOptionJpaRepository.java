package com.app.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.domain.repositories.IProductOptionRepository;
import com.app.infrastructure.entity.ProductOptionEntity;

public interface ProductOptionJpaRepository extends JpaRepository<ProductOptionEntity,String>, IProductOptionRepository {
    
}
