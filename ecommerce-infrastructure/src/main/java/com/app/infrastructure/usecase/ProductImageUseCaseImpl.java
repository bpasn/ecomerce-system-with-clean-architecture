package com.app.infrastructure.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.app.domain.entity.ProductImageEntity;
import com.app.domain.usecase.ProductImageUseCase;
import com.app.infrastructure.repositories.ProductImageJpaRepository;

@Service()
public class ProductImageUseCaseImpl implements ProductImageUseCase {

    private final ProductImageJpaRepository repository;

    public ProductImageUseCaseImpl(ProductImageJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductImageEntity insert(ProductImageEntity entity) {
       return repository.save(entity);
    }

    @Override
    public ProductImageEntity update(Long id, ProductImageEntity entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public List<ProductImageEntity> insertAll(List<ProductImageEntity> entity) {
        System.out.println(entity.get(0));
       return repository.saveAll(entity);
    }

    @Override
    public Optional<ProductImageEntity> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Page<ProductImageEntity> findAllWithPageable(int size, int page) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllWithPageable'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<ProductImageEntity> findAll() {
        return repository.findAll();
    }
}
