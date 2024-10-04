package com.app.application.mapper;

import com.app.application.dto.OrderDTO;
import com.app.domain.models.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring",uses = {OrderItemMapper.class})
public abstract class OrderMapperAbstract implements OrderMapper{

    @Autowired
    private  OrderItemMapper orderItemMapper;

    @Override
    @Mapping(target = "orderItems", expression = "java(order.getOrderItems().stream().map(orderItemMapper::toDTO).toList())")
    public abstract OrderDTO toDTO(Order order);

}
