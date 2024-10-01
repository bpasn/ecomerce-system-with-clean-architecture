package com.app.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.app.domain.models.Order;
import com.app.infrastructure.entity.OrderEntity;

@Mapper(componentModel = "spring")
public interface OrderMapperInfra extends GenericMapper<OrderEntity, Order> {

}
