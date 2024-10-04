package com.app.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.infrastructure.entity.OrderItemOptionChoiceEntity;



public interface OrderItemOptionChoiceJpaRepository extends JpaRepository<OrderItemOptionChoiceEntity,String>{}