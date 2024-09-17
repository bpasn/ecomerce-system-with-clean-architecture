package com.app.infrastructure.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.domain.entity.ProductOptionEntity;
import com.app.domain.usecase.ProductOptionUseCase;
import com.app.infrastructure.repositories.ProductOptionJpaRepository;

@Service
public class ProductOptionUseCaseImpl extends BaseUseCaseImpl<ProductOptionEntity> implements ProductOptionUseCase{

    private final ProductOptionJpaRepository productOptionJpaRepository;
    

    public ProductOptionUseCaseImpl(ProductOptionJpaRepository productOptionJpaRepository) {
        super(productOptionJpaRepository);
        this.productOptionJpaRepository = productOptionJpaRepository;
    }

    @Override
    public ProductOptionEntity getByOptionName(String optionName) {
       return productOptionJpaRepository.findByOptionName(optionName);
    }

    @Override
    public List<ProductOptionEntity> findAllByStoreId(String storeId) {
        return productOptionJpaRepository.findAllByStoreId(storeId);
    }
    
}
