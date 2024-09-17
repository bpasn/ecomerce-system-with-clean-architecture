package com.app.domain.usecase;

import java.util.List;

import com.app.domain.entity.ProductOptionEntity;

public interface ProductOptionUseCase extends BaseUseCase<ProductOptionEntity>{
    ProductOptionEntity getByOptionName(String optionName);
    List<ProductOptionEntity> findAllByStoreId(String storeId);
}
