package com.app.infrastructure.usecase;

import org.springframework.stereotype.Service;

import com.app.domain.entity.ProductImageEntity;
import com.app.domain.usecase.ProductImageUseCase;
import com.app.infrastructure.repositories.ProductImageJpaRepository;

@Service()
public class ProductImageUseCaseImpl extends BaseUseCaseImpl<ProductImageEntity> implements ProductImageUseCase {

    private final ProductImageJpaRepository repository;

    public ProductImageUseCaseImpl(ProductImageJpaRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public ProductImageEntity save(ProductImageEntity entity) {
       return repository.save(entity);
    }

   
}
