package com.app.infrastructure.usecase;

import org.springframework.stereotype.Service;

import com.app.domain.entity.CategoriesEntity;
import com.app.domain.usecase.CategoryUseCase;
import com.app.infrastructure.repositories.CategoriesJpaRepository;


@Service
public class CategoriesUseCaseImpl extends BaseUseCaseImpl<CategoriesEntity> implements CategoryUseCase{
    private final CategoriesJpaRepository categoriesJpaRepository;

    public CategoriesUseCaseImpl(CategoriesJpaRepository categoriesJpaRepository) {
        super(categoriesJpaRepository);
        this.categoriesJpaRepository = categoriesJpaRepository;
    }

    @Override
    public CategoriesEntity findByName(String name) {
        return categoriesJpaRepository.findByName(name).orElse(null);
    }

    @Override
    public boolean isExistsName(String name) {
       return categoriesJpaRepository.existsByName(name);
    }

    
}
