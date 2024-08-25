package com.app.domain.repositories;

import java.util.Optional;

import com.app.domain.entity.ProductGroupEntity;

public interface IProductGroupRepository {
    Optional<ProductGroupEntity> findByGroupName(String groupName);
    ProductGroupEntity save(ProductGroupEntity productGroupEntity);
    boolean existsById(Long id);
    void deleteById(Long id);
}
