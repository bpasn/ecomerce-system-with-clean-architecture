package com.app.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.domain.models.Store;
import com.app.infrastructure.entity.ProductCategoriesEntity;

public interface ProductCategoriesJpaRepository extends JpaRepository<ProductCategoriesEntity,String> {
    boolean existsByName(String name);
     Optional<ProductCategoriesEntity> findByName(String name);
    List<ProductCategoriesEntity> findAllByStore(Store store);
    List<ProductCategoriesEntity> findAllByStoreId(String storeId);
}
