package com.app.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.domain.entity.ProductGroupEntity;
import com.app.domain.repositories.IProductGroupRepository;

public interface ProductGroupJpaRepository extends JpaRepository<ProductGroupEntity,String>, IProductGroupRepository {
}
