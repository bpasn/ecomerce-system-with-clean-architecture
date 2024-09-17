package com.app.domain.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.app.domain.entity.ProductEntity;

public interface ProductUseCase extends BaseUseCase<ProductEntity>{
    Optional<ProductEntity> findByNameTH(String name);
    List<ProductEntity> findAllByStoreId(String storeId);
    Page<ProductEntity> findAllByStoreIdWithPageable(String storeId,int page,int size);
    
}
