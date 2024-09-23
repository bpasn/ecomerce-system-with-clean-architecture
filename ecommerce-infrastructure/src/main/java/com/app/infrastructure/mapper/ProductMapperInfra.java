package com.app.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.app.domain.models.Product;
import com.app.infrastructure.entity.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductMapperInfra extends GenericMapper<ProductEntity, Product> {
    ProductMapperInfra INSTANCE = Mappers.getMapper(ProductMapperInfra.class);
}
