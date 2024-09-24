package com.app.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.domain.projections.StockProductProjection;
import com.app.infrastructure.entity.ProductEntity;


public interface ProductJpaRepository extends JpaRepository<ProductEntity,String>{
     Optional<ProductEntity> findByNameTH(String name);

    List<ProductEntity> findAllByStoreId(String storeId);

    Page<ProductEntity> findAllByStoreId(String storeId, Pageable pageable);

    @Query(value = "SELECT * FROM public.product_stock_function(:storeId)",nativeQuery = true)
    List<StockProductProjection> findProductStockAllByStoreIdNative(@Param("storeId") String storeId);
}
