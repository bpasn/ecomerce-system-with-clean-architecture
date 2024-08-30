package com.app.domain.repositories;

import java.util.Optional;

import com.app.domain.entity.ProductEntity;

public interface IProductRepository {
    Optional<ProductEntity> findByName(String name);
}
