package com.app.infrastructure.mapper;

import com.app.domain.models.OrderItemOptionChoice;
import com.app.infrastructure.entity.OrderItemOptionChoiceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderItemOptionChoiceMapperInfra extends GenericMapper<OrderItemOptionChoiceEntity, OrderItemOptionChoice>{
}
