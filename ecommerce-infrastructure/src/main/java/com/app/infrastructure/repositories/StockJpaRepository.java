package com.app.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.domain.repositories.IStockRepository;
import com.app.infrastructure.entity.StockEntity;;

public interface StockJpaRepository extends JpaRepository<StockEntity,String> , IStockRepository {
}