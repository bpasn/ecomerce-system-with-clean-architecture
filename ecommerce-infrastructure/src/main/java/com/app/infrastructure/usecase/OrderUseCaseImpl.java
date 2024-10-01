package com.app.infrastructure.usecase;

import org.springframework.stereotype.Service;

import com.app.domain.models.Order;
import com.app.domain.usecase.OrderUseCase;
import com.app.infrastructure.entity.OrderEntity;
import com.app.infrastructure.mapper.OrderMapperInfra;
import com.app.infrastructure.repositories.OrderJpaRepository;

@Service
public class OrderUseCaseImpl extends BaseUseCaseImpl<OrderEntity, Order> implements OrderUseCase {

    public OrderUseCaseImpl(OrderJpaRepository repository, OrderMapperInfra mapper) {
        super(repository, mapper);
    }

}
