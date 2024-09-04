package com.app.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.domain.entity.StockEntity;
import com.app.domain.repositories.IStockRepository;;

public interface StockJpaRepository extends JpaRepository<StockEntity,String> , IStockRepository {
}