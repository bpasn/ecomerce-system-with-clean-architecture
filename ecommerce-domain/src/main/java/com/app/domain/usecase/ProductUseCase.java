package com.app.domain.usecase;

import java.util.List;
import java.util.Optional;

import com.app.domain.models.Product;
import com.app.domain.pageable.PageResult;
import com.app.domain.projections.StockProductProjection;

public interface ProductUseCase extends BaseUseCase<Product>{
    Optional<Product> findByNameTH(String name);
    List<Product> findAllByStoreId(String storeId);
    PageResult<Product> findAllByStoreIdWithPageable(String storeId,int page,int size);
    List<StockProductProjection> findProductStockAllByStoreIdNative(String storeId);
    Optional<Product> findByStockId(String stockId);
    
}
