package com.app.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.app.domain.entity.ProductCategoriesEntity;
import com.app.domain.entity.StoreEntity;

public interface IProductCategoriesRepository {
    Optional<ProductCategoriesEntity> findByName(String name);
    List<ProductCategoriesEntity> findAllByStore(StoreEntity store);
    List<ProductCategoriesEntity> findAllByStoreId(String storeId);
}
