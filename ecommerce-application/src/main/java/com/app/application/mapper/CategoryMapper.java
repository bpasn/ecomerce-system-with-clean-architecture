package com.app.application.mapper;

import com.app.application.dto.CategoriesDTO;
import com.app.domain.entity.ProductCategoriesEntity;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends BaseMapper<CategoriesDTO,ProductCategoriesEntity>{
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

}
