package com.app.infrastructure.mapper;

import com.app.domain.models.OptionChoice;
import com.app.domain.models.OrderItemOption;
import com.app.domain.models.OrderItemOptionChoice;
import com.app.infrastructure.entity.OptionChoiceEntity;
import com.app.infrastructure.entity.OrderItemOptionChoiceEntity;
import com.app.infrastructure.entity.OrderItemOptionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderItemOptionMapperInfra extends GenericMapper<OrderItemOptionEntity, OrderItemOption>{

    @Override
    @Mapping(target = "orderItem.product",ignore = true)
    @Mapping(target = "orderItem.order",ignore = true)
    @Mapping(target = "orderItem.orderItemOptions",ignore = true)
    @Mapping(target = "productOption.choices",ignore = true)
    @Mapping(target = "orderItemOptionChoice",expression = "java(option.getOrderItemOptionChoice().stream().map(e -> toOptionItemOptionChoice(e)).toList())")
    OrderItemOption toModel(OrderItemOptionEntity option);
    default OrderItemOptionChoice toOptionItemOptionChoice(OrderItemOptionChoiceEntity o){
        OptionChoiceEntity oe = o.getOptionChoice();
        return new OrderItemOptionChoice(o.getId(),new OptionChoice(oe.getId(),oe.getName(),oe.getChoiceEffect(),oe.getPrice(),oe.getStatus()));
    }
    @Override
    @Mapping(target = "orderItem.orderItemOptions",ignore = true)
    @Mapping(target = "productOption.choices",ignore = true)
    @Mapping(target = "orderItemOptionChoice",ignore = true)
    OrderItemOptionEntity toEntity(OrderItemOption option);
}
