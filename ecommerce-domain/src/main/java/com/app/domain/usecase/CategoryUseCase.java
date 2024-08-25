package com.app.domain.usecase;

import com.app.domain.entity.CategoriesEntity;

public interface CategoryUseCase  extends BaseUserCase<CategoriesEntity>{
    CategoriesEntity findByName(String name);
    boolean isExistsName(String name);
}
