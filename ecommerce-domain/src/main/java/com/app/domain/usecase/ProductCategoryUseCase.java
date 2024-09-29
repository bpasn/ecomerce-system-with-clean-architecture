package com.app.domain.usecase;

import java.util.List;

import com.app.domain.models.ProductCategories;
import com.app.domain.models.Store;
import com.app.domain.projections.CategoryWithProductProjection;

public interface ProductCategoryUseCase extends BaseUseCase<ProductCategories> {
    ProductCategories findByName(String name);

    boolean isExistsName(String name);

    List<ProductCategories> findAllByStore(Store store);

    List<ProductCategories> findAllByStoreId(String storeId);

    List<CategoryWithProductProjection> findAllCategoryWithProductProjections();

}
