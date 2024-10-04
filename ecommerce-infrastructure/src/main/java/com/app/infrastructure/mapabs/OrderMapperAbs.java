package com.app.infrastructure.mapabs;

import com.app.domain.models.Order;
import com.app.domain.models.OrderItem;
import com.app.infrastructure.entity.OrderEntity;
import com.app.infrastructure.entity.OrderItemEntity;
import com.app.infrastructure.mapper.OrderMapperInfra;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",uses = {OrderItemMapperAbs.class})
public abstract class OrderMapperAbs implements OrderMapperInfra {

    @Autowired
    protected OrderItemMapperAbs orderItemMapperAbs;

    @Override
    @Mapping(target = "orderItems",expression = "java(toOrderItems(order.getOrderItems()))")
    public abstract Order toModel(OrderEntity order);

    public  List<OrderItem> toOrderItems(List<OrderItemEntity> orderItems){
        return orderItems.stream().map(orderItemMapperAbs::toModel).collect(Collectors.toList());
    }
}
