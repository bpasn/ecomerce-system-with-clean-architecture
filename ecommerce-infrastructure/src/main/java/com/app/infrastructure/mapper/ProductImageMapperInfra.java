package com.app.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.app.domain.models.ProductImage;
import com.app.infrastructure.entity.ProductImageEntity;

@Mapper(componentModel = "spring")
public interface ProductImageMapperInfra extends GenericMapper<ProductImageEntity, ProductImage> {


    @Override
    @Mapping(target = "product.productImages",ignore = true)
    @Mapping(target = "product.stock",ignore = true)
    @Mapping(target = "product.categories",ignore = true)
    @Mapping(target = "product.productOptions",ignore = true)
    ProductImage toModel(ProductImageEntity productImage);

    @Override
    @Mapping(target = "product.productImages",ignore = true)
    @Mapping(target = "product.stock",ignore = true)
    @Mapping(target = "product.categories",ignore = true)
    @Mapping(target = "product.productOptions",ignore = true)
    ProductImageEntity toEntity(ProductImage productImage);
}
