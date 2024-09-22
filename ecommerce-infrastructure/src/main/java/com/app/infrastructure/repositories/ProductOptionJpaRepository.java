package com.app.infrastructure.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.infrastructure.entity.ProductOptionEntity;

public interface ProductOptionJpaRepository extends JpaRepository<ProductOptionEntity, String> {
    ProductOptionEntity findByOptionName(String optionName);

    List<ProductOptionEntity> findAllByStoreId(String storeId);
}
