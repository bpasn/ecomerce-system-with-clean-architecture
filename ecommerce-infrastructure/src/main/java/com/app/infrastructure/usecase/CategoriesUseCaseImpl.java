package com.app.infrastructure.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.domain.entity.CategoriesEntity;
import com.app.domain.usecase.CategoryUseCase;
import com.app.infrastructure.repositories.CategoriesJpaRepository;

import jakarta.transaction.Transactional;

@Service
public class CategoriesUseCaseImpl implements CategoryUseCase{
    private final CategoriesJpaRepository categoriesJpaRepository;

    

    public CategoriesUseCaseImpl(CategoriesJpaRepository categoriesJpaRepository) {
        this.categoriesJpaRepository = categoriesJpaRepository;
    }

    @Override
    @Transactional
    public CategoriesEntity insert(CategoriesEntity entity) {
        return categoriesJpaRepository.save(entity);
    }

    @Override
    @Transactional
    public CategoriesEntity update(Long id, CategoriesEntity entity) {
        return categoriesJpaRepository.save(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
       categoriesJpaRepository.deleteById(id);
    }

    @Override
    public CategoriesEntity findByName(String name) {
        return categoriesJpaRepository.findByName(name).orElse(null);
    }

    @Override
    @Transactional
    public List<CategoriesEntity> insertAll(List<CategoriesEntity> entity) {
        return categoriesJpaRepository.saveAll(entity);
    }

    @Override
    public Optional<CategoriesEntity> findById(Long id) {
       return categoriesJpaRepository.findById(id);
    }

    @Override
    public Page<CategoriesEntity> findAllWithPageable(int size,int page) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        return categoriesJpaRepository.findAll(pageable);
    }

    @Override
    public boolean isExistsName(String name) {
        return categoriesJpaRepository.existsByName(name);
    }
    
}
