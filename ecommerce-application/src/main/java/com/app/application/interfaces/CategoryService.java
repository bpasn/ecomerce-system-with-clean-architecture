package com.app.application.interfaces;

import com.app.application.dto.CategoriesDTO;
import com.app.domain.entity.ProductCategoriesEntity;

public interface CategoryService extends BaseService<ProductCategoriesEntity,CategoriesDTO> {
    CategoriesDTO getByName(String name);
}
