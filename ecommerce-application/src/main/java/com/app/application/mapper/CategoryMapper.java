package com.app.application.mapper;

import com.app.application.dto.CategoriesDTO;
import com.app.domain.entity.CategoriesEntity;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends BaseMapper<CategoriesDTO,CategoriesEntity>{
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

}
