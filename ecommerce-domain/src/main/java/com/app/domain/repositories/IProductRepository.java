package com.app.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.app.domain.entity.ProductEntity;

public interface IProductRepository {
    Optional<ProductEntity> findByNameTH(String name);

    List<ProductEntity> findAllByStoreId(String storeId);

    Page<ProductEntity> findAllByStoreId(String storeId, Pageable pageable);
}
