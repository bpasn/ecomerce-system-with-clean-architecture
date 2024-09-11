package com.app.infrastructure.usecase;

import org.springframework.stereotype.Service;

import com.app.domain.entity.ProductCategoriesEntity;
import com.app.domain.usecase.ProductCategoryUseCase;
import com.app.infrastructure.repositories.ProductCategoriesJpaRepository;


@Service
public class ProductCategoriesUseCaseImpl extends BaseUseCaseImpl<ProductCategoriesEntity> implements ProductCategoryUseCase{
    private final ProductCategoriesJpaRepository categoriesJpaRepository;

    public ProductCategoriesUseCaseImpl(ProductCategoriesJpaRepository categoriesJpaRepository) {
        super(categoriesJpaRepository);
        this.categoriesJpaRepository = categoriesJpaRepository;
    }

    @Override
    public ProductCategoriesEntity findByName(String name) {
        return categoriesJpaRepository.findByName(name).orElse(null);
    }

    @Override
    public boolean isExistsName(String name) {
       return categoriesJpaRepository.existsByName(name);
    }

    
}
