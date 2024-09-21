package com.app.infrastructure.usecase;

import org.springframework.stereotype.Service;

import com.app.domain.models.ProductImage;
import com.app.domain.usecase.ProductImageUseCase;
import com.app.infrastructure.entity.ProductImageEntity;
import com.app.infrastructure.repositories.ProductImageJpaRepository;

@Service()
public class ProductImageUseCaseImpl extends BaseUseCaseImpl<ProductImageEntity,ProductImage> implements ProductImageUseCase{

    private final ProductImageJpaRepository repository;

    public ProductImageUseCaseImpl(ProductImageJpaRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
