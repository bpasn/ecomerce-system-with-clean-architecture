package com.app.domain.usecase;

import com.app.domain.entity.ProductCategoriesEntity;
import com.app.domain.entity.StoreEntity;

import java.util.List;

public interface ProductCategoryUseCase  extends BaseUseCase<ProductCategoriesEntity>{
    ProductCategoriesEntity findByName(String name);
    boolean isExistsName(String name);
    List<ProductCategoriesEntity> findAllByStore(StoreEntity store);
    List<ProductCategoriesEntity> findAllByStoreId(String storeId);
}
