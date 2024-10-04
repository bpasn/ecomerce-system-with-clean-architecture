package com.app.application.mapper;

import com.app.application.dto.OrderItemDTO;
import com.app.domain.models.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderItemMapper extends BaseMapper<OrderItemDTO, OrderItem>{

    @Override
    @Mapping(target = "product.categories",ignore = true)
    @Mapping(target = "product.productOptions",ignore = true)
    @Mapping(target = "product.stock",ignore = true)
    @Mapping(target = "product.storeId",ignore = true)
    OrderItemDTO toDTO(OrderItem orderItem);
}
