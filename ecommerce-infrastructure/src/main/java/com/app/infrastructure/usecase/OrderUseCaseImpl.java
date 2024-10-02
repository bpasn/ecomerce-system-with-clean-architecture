package com.app.infrastructure.usecase;

import com.app.domain.models.OrderItem;
import com.app.infrastructure.mapper.OrderItemMapperInfra;
import com.app.infrastructure.repositories.OrderItemJpaRepository;
import org.springframework.stereotype.Service;

import com.app.domain.models.Order;
import com.app.domain.usecase.OrderUseCase;
import com.app.infrastructure.entity.OrderEntity;
import com.app.infrastructure.mapper.OrderMapperInfra;
import com.app.infrastructure.repositories.OrderJpaRepository;

@Service
public class OrderUseCaseImpl extends BaseUseCaseImpl<OrderEntity, Order> implements OrderUseCase {

    private final OrderItemJpaRepository orderItemJpaRepository;
    public OrderUseCaseImpl(OrderJpaRepository repository, OrderMapperInfra mapper,OrderItemJpaRepository orderItemJpaRepository) {
        super(repository, mapper);
        this.orderItemJpaRepository = orderItemJpaRepository;
    }

    @Override
    public void createOrderItem(OrderItem orderItem) {
        orderItemJpaRepository.save(OrderItemMapperInfra.INSTANT.toEntity(orderItem));
    }
}
