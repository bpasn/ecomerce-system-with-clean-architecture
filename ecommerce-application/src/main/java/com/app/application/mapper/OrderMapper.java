package com.app.application.mapper;

import org.mapstruct.Mapper;

import com.app.application.dto.OrderDTO;
import com.app.domain.models.Order;

@Mapper(componentModel = "spring",uses = {OrderItemMapper.class})
public interface OrderMapper extends BaseMapper<OrderDTO,Order> {

}
