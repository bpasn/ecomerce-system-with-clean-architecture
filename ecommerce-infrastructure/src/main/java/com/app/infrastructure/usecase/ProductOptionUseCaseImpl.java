package com.app.infrastructure.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.app.domain.entity.ProductOptionEntity;
import com.app.domain.usecase.ProductOptionUseCase;
import com.app.infrastructure.repositories.ProductOptionJpaRepository;

@Service
public class ProductOptionUseCaseImpl implements ProductOptionUseCase{

    private final ProductOptionJpaRepository productOptionJpaRepository;
    

    public ProductOptionUseCaseImpl(ProductOptionJpaRepository productOptionJpaRepository) {
        this.productOptionJpaRepository = productOptionJpaRepository;
    }

    @Override
    public ProductOptionEntity insert(ProductOptionEntity entity) {
        return productOptionJpaRepository.save(entity);
    }

    @Override
    public ProductOptionEntity update(Long id, ProductOptionEntity entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public List<ProductOptionEntity> insertAll(List<ProductOptionEntity> entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertAll'");
    }

    @Override
    public Optional<ProductOptionEntity> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Page<ProductOptionEntity> findAllWithPageable(int size, int page) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllWithPageable'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<ProductOptionEntity> findAll() {
       return productOptionJpaRepository.findAll();
    }

    @Override
    public ProductOptionEntity getByOptionName(String optionName) {
       return productOptionJpaRepository.findByOptionName(optionName);
    }
    
}
