package com.app.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.app.domain.models.ProductCategories;
import com.app.infrastructure.entity.ProductCategoriesEntity;

@Mapper(componentModel = "spring")
public interface ProductCategoryMapperInfra extends GenericMapper<ProductCategoriesEntity, ProductCategories> {
    ProductCategoryMapperInfra INSTANCE = Mappers.getMapper(ProductCategoryMapperInfra.class);
}
