package com.app.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.domain.entity.ProductOptionEntity;
import com.app.domain.repositories.IProductOptionRepository;

public interface ProductOptionJpaRepository extends JpaRepository<ProductOptionEntity,String>, IProductOptionRepository {
    
}
