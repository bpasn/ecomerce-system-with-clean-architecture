package com.app.infrastructure.usecase;

import java.util.List;

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

    public ProductCategoriesUseCaseImpl(ProductCategoriesJpaRepository categoriesJpaRepository,
            ProductCategoryMapperInfra mapper) {
        super(categoriesJpaRepository, mapper);
        this.categoriesJpaRepository = categoriesJpaRepository;
    }

    @Override
    public ProductCategories findByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByName'");
    }

    @Override
    public boolean isExistsName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isExistsName'");
    }

    @Override
    public List<ProductCategories> findAllByStore(Store store) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllByStore'");
    }

    @Override
    public List<ProductCategories> findAllByStoreId(String storeId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllByStoreId'");
    }

}
