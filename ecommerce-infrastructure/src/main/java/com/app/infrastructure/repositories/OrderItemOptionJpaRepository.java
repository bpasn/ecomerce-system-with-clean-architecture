package com.app.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.infrastructure.entity.OrderItemOptionEntity;

public interface OrderItemOptionJpaRepository extends JpaRepository<OrderItemOptionEntity, String> {
}
