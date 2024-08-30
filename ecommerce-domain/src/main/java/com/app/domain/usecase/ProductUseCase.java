package com.app.domain.usecase;

import java.util.Optional;

import com.app.domain.entity.ProductEntity;

public interface ProductUseCase extends BaseUseCase<ProductEntity>{
    Optional<ProductEntity> findByName(String name);
}
