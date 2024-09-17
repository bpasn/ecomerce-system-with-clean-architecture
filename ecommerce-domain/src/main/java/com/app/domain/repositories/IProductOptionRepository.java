package com.app.domain.repositories;

import java.util.List;

import com.app.domain.entity.ProductOptionEntity;

public interface IProductOptionRepository {
    ProductOptionEntity findByOptionName(String optionName);
    List<ProductOptionEntity> findAllByStoreId(String storeId);
}
