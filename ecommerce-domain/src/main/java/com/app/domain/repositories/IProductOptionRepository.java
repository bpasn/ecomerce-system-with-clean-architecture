package com.app.domain.repositories;

import com.app.domain.entity.ProductOptionEntity;

public interface IProductOptionRepository {
    ProductOptionEntity findByOptionName(String optionName);
}
