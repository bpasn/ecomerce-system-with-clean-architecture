package com.app.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.app.domain.models.OrderItem;
import com.app.infrastructure.entity.OrderItemEntity;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderItemMapperInfra extends GenericMapper<OrderItemEntity, OrderItem> {
OrderItemMapperInfra INSTANT = Mappers.getMapper(OrderItemMapperInfra.class);

    @Override
    @Mapping(target="order.orderItems",ignore = true)
    OrderItem toModel(OrderItemEntity orderItem);

    @Override
    @Mapping(target="order.orderItems",ignore = true)
    OrderItemEntity toEntity(OrderItem order);
}
