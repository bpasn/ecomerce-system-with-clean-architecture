package com.app.infrastructure.mapper;


import com.app.domain.models.OrderItem;
import com.app.infrastructure.entity.OrderItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderItemMapperInfra extends GenericMapper<OrderItemEntity, OrderItem>{
    OrderItemMapperInfra INSTANCE = Mappers.getMapper(OrderItemMapperInfra.class);
    @Override
    @Mapping(target="order.orderItems",ignore = true)
    @Mapping(target="product.productOptions" , ignore = true)
    @Mapping(target="product.categories" , ignore = true)
    @Mapping(target="product.stock" , ignore = true)
    @Mapping(target="product.productImages" , ignore = true)
    OrderItemEntity toEntity(OrderItem order);

    @Override
    @Mapping(target="order.orderItems",ignore = true)
    @Mapping(target="product.productOptions" , ignore = true)
    @Mapping(target="product.categories" , ignore = true)
    @Mapping(target="product.stock" , ignore = true)
    OrderItem toModel(OrderItemEntity order);
}
