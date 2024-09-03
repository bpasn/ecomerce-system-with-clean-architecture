package com.app.infrastructure.repositories;

import com.app.domain.entity.ProductGroupEntity;
import com.app.domain.repositories.IProductGroupRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductGroupJpaRepository extends JpaRepository<ProductGroupEntity,UUID>, IProductGroupRepository {
}
