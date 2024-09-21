package com.app.domain.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.app.domain.models.Product;

public interface ProductUseCase extends BaseUseCase<Product>{
    Optional<Product> findByNameTH(String name);
    List<Product> findAllByStoreId(String storeId);
    Page<Product> findAllByStoreIdWithPageable(String storeId,int page,int size);
    
}
