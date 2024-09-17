package com.app.application.interfaces;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.CategoriesDTO;
import com.app.domain.entity.ProductCategoriesEntity;

import java.util.List;

public interface CategoryService extends BaseService<ProductCategoriesEntity,CategoriesDTO> {
    CategoriesDTO getByName(String name);
    ApiResponse<List<CategoriesDTO>> getAllByStoreId(String storeId);
}
