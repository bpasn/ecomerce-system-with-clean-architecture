package com.app.application.interfaces;

import com.app.application.dto.CategoriesDTO;
import com.app.domain.entity.CategoriesEntity;

public interface CategoryService extends BaseService<CategoriesEntity,CategoriesDTO> {
    CategoriesDTO getByName(String name);
}
