package com.app.application.mapper;

import com.app.application.dto.CategoriesDTO;
import com.app.domain.models.ProductCategories;
import com.app.domain.models.Store;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductCategoryMapper extends BaseMapper<CategoriesDTO,ProductCategories>{
    ProductCategoryMapper INSTANCE = Mappers.getMapper(ProductCategoryMapper.class);


    @Override
    @Mapping(source = "store.id",target = "storeId")
    CategoriesDTO toDTO(ProductCategories entity);



}
