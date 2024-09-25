package com.app.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.app.application.dto.CategoriesDTO;
import com.app.domain.models.ProductCategories;

@Mapper(componentModel = "spring")
public interface ProductCategoryMapper extends BaseMapper<CategoriesDTO,ProductCategories>{
    ProductCategoryMapper INSTANCE = Mappers.getMapper(ProductCategoryMapper.class);


    @Override
    @Mapping(source = "store.id",target = "storeId")
    CategoriesDTO toDTO(ProductCategories entity);



}