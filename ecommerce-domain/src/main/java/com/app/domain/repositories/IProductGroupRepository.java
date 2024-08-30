package com.app.domain.repositories;

import java.util.Optional;

import com.app.domain.entity.ProductGroupEntity;

public interface IProductGroupRepository {
    Optional<ProductGroupEntity> findByGroupName(String groupName);
}
