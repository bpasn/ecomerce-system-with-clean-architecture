package com.app.domain.usecase;

import com.app.domain.entity.CategoriesEntity;

public interface CategoryUseCase  extends BaseUseCase<CategoriesEntity>{
    CategoriesEntity findByName(String name);
    boolean isExistsName(String name);
}
