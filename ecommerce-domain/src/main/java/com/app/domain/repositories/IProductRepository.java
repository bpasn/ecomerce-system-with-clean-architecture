package com.app.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.app.domain.models.Product;

public interface IProductRepository {
    Optional<Product> findByNameTH(String name);

    List<Product> findAllByStoreId(String storeId);

    Page<Product> findAllByStoreId(String storeId, Pageable pageable);
}
