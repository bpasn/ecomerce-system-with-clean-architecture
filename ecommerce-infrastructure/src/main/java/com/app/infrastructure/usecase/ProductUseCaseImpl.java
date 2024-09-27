package com.app.infrastructure.usecase;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.domain.models.Product;
import com.app.domain.pageable.PageResult;
import com.app.domain.projections.StockProductProjection;
import com.app.domain.usecase.ProductUseCase;
import com.app.infrastructure.entity.ProductEntity;
import com.app.infrastructure.mapper.ProductMapperInfra;
import com.app.infrastructure.repositories.ProductJpaRepository;

@Service
public class ProductUseCaseImpl extends BaseUseCaseImpl<ProductEntity, Product> implements ProductUseCase {
    private final ProductJpaRepository productJpaRepository;

    public ProductUseCaseImpl(ProductJpaRepository productJpaRepository, ProductMapperInfra mapper) {
        super(productJpaRepository, mapper);
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public Optional<Product> findByNameTH(String name) {
        return productJpaRepository.findByNameTH(name).map(ProductMapperInfra.INSTANCE::toModel);
    }

    @Override
    public List<Product> findAllByStoreId(String storeId) {
        return productJpaRepository.findAllByStoreId(storeId).stream().map(ProductMapperInfra.INSTANCE::toModel)
                .toList();
    }

    @Override
    public PageResult<Product> findAllByStoreIdWithPageable(String storeId, int page, int size) {
        Page<ProductEntity> result = productJpaRepository.findAllByStoreId(storeId,
                Pageable.ofSize(size).withPage(page));
        PageResult<Product> pageResult = new PageResult<>(
                result.getContent().stream().map(ProductMapperInfra.INSTANCE::toModel).collect(Collectors.toList()),
                result.getNumber(),
                result.getSize(),
                result.getTotalElements(),
                result.getTotalPages());
        return pageResult;
    }

    @Override
    public List<StockProductProjection> findProductStockAllByStoreIdNative(String storeId) {
       return productJpaRepository.findProductStockAllByStoreIdNative(storeId);
    }

    @Override
    public Optional<Product> findByStockId(String stockId) {
        return productJpaRepository.findByStockId(stockId).map(ProductMapperInfra.INSTANCE::toModel);
    }

}
