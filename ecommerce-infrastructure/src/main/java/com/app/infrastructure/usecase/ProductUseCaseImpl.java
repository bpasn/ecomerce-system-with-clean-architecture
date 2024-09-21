package com.app.infrastructure.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.app.domain.models.Product;
import com.app.domain.usecase.ProductUseCase;
import com.app.infrastructure.entity.ProductEntity;
import com.app.infrastructure.repositories.ProductJpaRepository;

@Service
public class ProductUseCaseImpl extends BaseUseCaseImpl<ProductEntity,Product> implements ProductUseCase {
    private final ProductJpaRepository productJpaRepository;

    public ProductUseCaseImpl(ProductJpaRepository productJpaRepository) {
        super(productJpaRepository);
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public Optional<Product> findByNameTH(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByNameTH'");
    }

    @Override
    public List<Product> findAllByStoreId(String storeId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllByStoreId'");
    }

    @Override
    public Page<Product> findAllByStoreIdWithPageable(String storeId, int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllByStoreIdWithPageable'");
    }

}
