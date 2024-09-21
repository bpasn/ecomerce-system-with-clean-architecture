package com.app.domain.usecase;

import java.util.List;

import com.app.domain.models.ProductOption;

public interface ProductOptionUseCase extends BaseUseCase<ProductOption>{
    ProductOption getByOptionName(String optionName);
    List<ProductOption> findAllByStoreId(String storeId);
}
