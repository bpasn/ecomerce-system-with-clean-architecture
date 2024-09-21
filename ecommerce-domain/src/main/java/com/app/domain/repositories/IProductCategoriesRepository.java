package com.app.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.app.domain.models.ProductCategories;
import com.app.domain.models.Store;

public interface IProductCategoriesRepository {
    Optional<ProductCategories> findByName(String name);
    List<ProductCategories> findAllByStore(Store store);
    List<ProductCategories> findAllByStoreId(String storeId);
}
