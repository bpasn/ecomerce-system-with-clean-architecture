package com.app.domain.repositories;

import java.util.Optional;

import com.app.domain.entity.ProductCategoriesEntity;

public interface IProductCategoriesRepository {
    Optional<ProductCategoriesEntity> findByName(String name);
}
