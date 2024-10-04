package com.app.infrastructure.usecase;

import com.app.domain.models.OrderItem;
import com.app.domain.models.OrderItemOption;
import com.app.domain.models.OrderItemOptionChoice;
import com.app.infrastructure.mapabs.OrderItemMapperAbs;
import com.app.infrastructure.mapabs.OrderMapperAbs;
import com.app.infrastructure.mapper.OrderItemOptionChoiceMapperInfra;
import com.app.infrastructure.mapper.OrderItemOptionMapperInfra;
import com.app.infrastructure.repositories.OrderItemJpaRepository;
import com.app.infrastructure.repositories.OrderItemOptionChoiceJpaRepository;
import com.app.infrastructure.repositories.OrderItemOptionJpaRepository;
import org.springframework.stereotype.Service;

import com.app.domain.models.Order;
import com.app.domain.usecase.OrderUseCase;
import com.app.infrastructure.entity.OrderEntity;
import com.app.infrastructure.mapper.OrderMapperInfra;
import com.app.infrastructure.repositories.OrderJpaRepository;

@Service
public class OrderUseCaseImpl extends BaseUseCaseImpl<OrderEntity, Order> implements OrderUseCase {

    private final OrderItemJpaRepository orderItemJpaRepository;
    private final OrderItemOptionJpaRepository orderItemOptionJpaRepository;
    private final OrderItemOptionChoiceJpaRepository orderItemOptionChoiceJpaRepository;
    private final OrderItemMapperAbs orderItemMapperAbs;
    public OrderUseCaseImpl(
            OrderJpaRepository repository,
            OrderMapperAbs mapper,
            OrderItemJpaRepository orderItemJpaRepository,
            OrderItemMapperAbs orderItemMapperAbs,
            OrderItemOptionJpaRepository orderItemOptionJpaRepository,
            OrderItemOptionChoiceJpaRepository orderItemOptionChoiceJpaRepository
            ) {
        super(repository, mapper);
        this.orderItemJpaRepository = orderItemJpaRepository;
        this.orderItemMapperAbs = orderItemMapperAbs;
        this.orderItemOptionJpaRepository = orderItemOptionJpaRepository;
        this.orderItemOptionChoiceJpaRepository = orderItemOptionChoiceJpaRepository;
    }

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
      return orderItemMapperAbs.toModel(orderItemJpaRepository.save(orderItemMapperAbs.toEntity(orderItem)));
    }

    @Override
    public OrderItemOption createOrderItemOption(OrderItemOption orderItemoption) {
        return OrderItemOptionMapperInfra.INSTANCE.toModel(orderItemOptionJpaRepository.save(OrderItemOptionMapperInfra.INSTANCE.toEntity(orderItemoption)));
    }

    @Override
    public OrderItemOptionChoice createOrderItemOptionChoice(OrderItemOptionChoice orderItemOptionChoice) {
        return  OrderItemOptionChoiceMapperInfra.INSTANCE.toModel(orderItemOptionChoiceJpaRepository.save(OrderItemOptionChoiceMapperInfra.INSTANCE.toEntity(orderItemOptionChoice)));
    }
}
