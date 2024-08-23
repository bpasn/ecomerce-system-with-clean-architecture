package com.app.domain.repositories;

import java.util.Optional;

import com.app.domain.entity.ProductOptionGroupEntity;

public interface IProductOptionGroupRepository {
    Optional<ProductOptionGroupEntity> getByGroupName(String groupName);
}
