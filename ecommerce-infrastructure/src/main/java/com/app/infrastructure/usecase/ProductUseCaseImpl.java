package com.app.infrastructure.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.domain.entity.ProductEntity;
import com.app.domain.usecase.ProductUseCase;
import com.app.infrastructure.repositories.ProductJpaRepository;


@Service
public class ProductUseCaseImpl extends BaseUseCaseImpl<ProductEntity> implements ProductUseCase {
    private final ProductJpaRepository productJpaRepository;

    public ProductUseCaseImpl(ProductJpaRepository productJpaRepository) {
        super(productJpaRepository);
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public Optional<ProductEntity> findByNameTH(String name) {
       return productJpaRepository.findByNameTH(name);
    }


}
