package com.app.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.app.domain.models.OrderItem;
import com.app.infrastructure.entity.OrderItemEntity;

@Mapper(componentModel = "spring")
public interface OrderItemMapperInfra extends GenericMapper<OrderItemEntity, OrderItem> {

}
