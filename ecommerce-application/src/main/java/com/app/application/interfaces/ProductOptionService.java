package com.app.application.interfaces;

import java.util.List;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.ProductOptionDTO;
import com.app.domain.entity.ProductOptionEntity;

public interface ProductOptionService extends BaseService<ProductOptionEntity,ProductOptionDTO> {
    ProductOptionDTO getByOptionName(String optionName);
    ApiResponse<List<ProductOptionDTO>> getAllByStoreId(String storeId);
}
