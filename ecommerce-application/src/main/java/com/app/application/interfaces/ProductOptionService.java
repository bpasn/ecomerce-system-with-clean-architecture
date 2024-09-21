package com.app.application.interfaces;

import java.util.List;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.ProductOptionDTO;
import com.app.domain.models.ProductOption;

public interface ProductOptionService extends BaseService<ProductOption,ProductOptionDTO> {
    ProductOptionDTO getByOptionName(String optionName);
    ApiResponse<List<ProductOptionDTO>> getAllByStoreId(String storeId);
}
