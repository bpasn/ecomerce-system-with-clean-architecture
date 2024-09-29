package com.app.application.interfaces;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.CategoriesDTO;
import com.app.application.dto.CategoryWithProductDTO;
import com.app.domain.models.ProductCategories;

import java.util.List;

public interface CategoryService extends BaseService<ProductCategories,CategoriesDTO> {
    CategoriesDTO getByName(String name);
    ApiResponse<List<CategoriesDTO>> getAllByStoreId(String storeId);
    ApiResponse<List<CategoryWithProductDTO>> getAllCategoryWIthProduct();
}
