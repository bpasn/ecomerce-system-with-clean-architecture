package com.app.infrastructure.usecase;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.app.domain.models.ProductCategories;
import com.app.domain.models.Store;
import com.app.domain.usecase.ProductCategoryUseCase;
import com.app.infrastructure.entity.ProductCategoriesEntity;
import com.app.infrastructure.mapper.ProductCategoryMapperInfra;
import com.app.infrastructure.repositories.ProductCategoriesJpaRepository;

@Service
public class ProductCategoriesUseCaseImpl extends BaseUseCaseImpl<ProductCategoriesEntity, ProductCategories>
        implements ProductCategoryUseCase {
    private final ProductCategoriesJpaRepository categoriesJpaRepository;
    private final ProductCategoryMapperInfra productCategoryMapperInfra;

    public ProductCategoriesUseCaseImpl(ProductCategoriesJpaRepository categoriesJpaRepository,
            ProductCategoryMapperInfra mapper) {
        super(categoriesJpaRepository, mapper);
        this.categoriesJpaRepository = categoriesJpaRepository;
        this.productCategoryMapperInfra = mapper;
    }

    @Override
    public ProductCategories findByName(String name) {
       return productCategoryMapperInfra.toModel(categoriesJpaRepository.findByName(name).orElse(null));
    }

    @Override
    public boolean isExistsName(String name) {
       return categoriesJpaRepository.existsByName(name);
    }

    @Override
    public List<ProductCategories> findAllByStore(Store store) {
       return categoriesJpaRepository.findAllByStore(store).stream().map(productCategoryMapperInfra::toModel).toList();
    }

    @Override
    public List<ProductCategories> findAllByStoreId(String storeId) {
        return categoriesJpaRepository.findAllByStoreId(storeId).stream().map(productCategoryMapperInfra::toModel).collect(Collectors.toList());
    }

}
