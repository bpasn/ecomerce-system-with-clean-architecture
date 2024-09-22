package com.app.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.app.domain.models.ProductImage;
import com.app.infrastructure.entity.ProductImageEntity;

@Mapper(componentModel = "spring")
public interface ProductImageMapperInfra extends GenericMapper<ProductImageEntity, ProductImage> {

    ProductImageMapperInfra INSTANCE = Mappers.getMapper(ProductImageMapperInfra.class);
}
