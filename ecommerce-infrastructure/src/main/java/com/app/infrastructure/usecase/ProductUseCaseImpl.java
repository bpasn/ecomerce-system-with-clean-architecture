package com.app.infrastructure.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public List<ProductEntity> findAllByStoreId(String storeId) {
        return productJpaRepository.findAllByStoreId(storeId);
    }

    @Override
    public Page<ProductEntity> findAllByStoreIdWithPageable(String storeId, int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        return productJpaRepository.findAllByStoreId(storeId, pageable);
    }

}
