package com.app.infrastructure.usecase;

import com.app.domain.models.OrderItem;
import com.app.domain.models.OrderItemOption;
import com.app.domain.models.OrderItemOptionChoice;
import com.app.infrastructure.mapper.OrderItemMapperInfra;
import com.app.infrastructure.mapper.OrderItemOptionChoiceMapperInfra;
import com.app.infrastructure.mapper.OrderItemOptionMapperInfra;
import com.app.infrastructure.mapper.OrderMapperInfra;
import com.app.infrastructure.repositories.OrderItemJpaRepository;
import com.app.infrastructure.repositories.OrderItemOptionChoiceJpaRepository;
import com.app.infrastructure.repositories.OrderItemOptionJpaRepository;
import org.springframework.stereotype.Service;

import com.app.domain.models.Order;
import com.app.domain.usecase.OrderUseCase;
import com.app.infrastructure.entity.OrderEntity;
import com.app.infrastructure.repositories.OrderJpaRepository;

@Service
public class OrderUseCaseImpl extends BaseUseCaseImpl<OrderEntity, Order> implements OrderUseCase {

    private final OrderItemJpaRepository orderItemJpaRepository;
    private final OrderItemOptionJpaRepository orderItemOptionJpaRepository;
    private final OrderItemOptionChoiceJpaRepository orderItemOptionChoiceJpaRepository;
    private final OrderItemMapperInfra orderItemMapperInfra;
    private final OrderItemOptionMapperInfra orderItemOptionMapperInfra;
    private final OrderItemOptionChoiceMapperInfra orderItemOptionChoiceMapperInfra;
    public OrderUseCaseImpl(
            OrderJpaRepository repository,
            OrderMapperInfra mapper,
            OrderItemJpaRepository orderItemJpaRepository,
            OrderItemOptionJpaRepository orderItemOptionJpaRepository,
            OrderItemOptionChoiceJpaRepository orderItemOptionChoiceJpaRepository,
            OrderItemOptionMapperInfra orderItemOptionMapperInfra,
            OrderItemOptionChoiceMapperInfra orderItemOptionChoiceMapperInfra,
            OrderItemMapperInfra orderItemMapperInfra
            ) {
        super(repository, mapper);
        this.orderItemJpaRepository = orderItemJpaRepository;
        this.orderItemOptionJpaRepository = orderItemOptionJpaRepository;
        this.orderItemOptionChoiceJpaRepository = orderItemOptionChoiceJpaRepository;
        this.orderItemOptionMapperInfra = orderItemOptionMapperInfra;
        this.orderItemOptionChoiceMapperInfra=orderItemOptionChoiceMapperInfra;
        this.orderItemMapperInfra = orderItemMapperInfra;
    }

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
      return orderItemMapperInfra.toModel(orderItemJpaRepository.save(orderItemMapperInfra.toEntity(orderItem)));
    }

    @Override
    public OrderItemOption createOrderItemOption(OrderItemOption orderItemoption) {
        return orderItemOptionMapperInfra.toModel(orderItemOptionJpaRepository.save(orderItemOptionMapperInfra.toEntity(orderItemoption)));
    }

    @Override
    public OrderItemOptionChoice createOrderItemOptionChoice(OrderItemOptionChoice orderItemOptionChoice) {
        return  orderItemOptionChoiceMapperInfra.toModel(orderItemOptionChoiceJpaRepository.save(orderItemOptionChoiceMapperInfra.toEntity(orderItemOptionChoice)));
    }
}
