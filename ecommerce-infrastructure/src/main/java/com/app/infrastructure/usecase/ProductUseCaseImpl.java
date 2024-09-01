package com.app.infrastructure.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.domain.entity.ProductEntity;
import com.app.domain.usecase.ProductUseCase;
import com.app.infrastructure.repositories.ProductJpaRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductUseCaseImpl implements ProductUseCase {
    private final ProductJpaRepository productJpaRepository;

    public ProductUseCaseImpl(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public ProductEntity insert(ProductEntity entity) {
        return productJpaRepository.save(entity);
    }

    @Override
    public ProductEntity update(Long id, ProductEntity entity) {
        return productJpaRepository.save(entity);
    }

    @Override
    public List<ProductEntity> insertAll(List<ProductEntity> entity) {
        return productJpaRepository.saveAll(entity);
    }

    @Override
    public Optional<ProductEntity> findById(Long id) {
        return productJpaRepository.findById(id);
    }

    @Override
    public Page<ProductEntity> findAllWithPageable(int size, int page) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        return productJpaRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void delete(Long id) {
         productJpaRepository.deleteById(id);
    }

    @Override
    public Optional<ProductEntity> findByNameTH(String name) {
        return productJpaRepository.findByNameTH(name);
    }

    @Override
    public List<ProductEntity> findAll() {
        return productJpaRepository.findAll();
    }

}
