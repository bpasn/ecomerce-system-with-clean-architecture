package com.app.domain.usecase;

import com.app.domain.entity.ProductCategoriesEntity;

public interface ProductCategoryUseCase  extends BaseUseCase<ProductCategoriesEntity>{
    ProductCategoriesEntity findByName(String name);
    boolean isExistsName(String name);
}
