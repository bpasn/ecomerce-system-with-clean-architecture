package com.app.domain.repositories;

import java.util.List;

import com.app.domain.models.ProductOption;

public interface IProductOptionRepository {
    ProductOption findByOptionName(String optionName);
    List<ProductOption> findAllByStoreId(String storeId);
}
