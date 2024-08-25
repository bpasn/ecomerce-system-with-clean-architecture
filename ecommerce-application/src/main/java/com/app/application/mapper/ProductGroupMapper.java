package com.app.application.mapper;

import com.app.application.dto.ProductGroupDTO;
import com.app.domain.entity.ProductGroupEntity;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface ProductGroupMapper extends BaseMapper<ProductGroupDTO, ProductGroupEntity>{
    ProductGroupMapper INSTANCE = Mappers.getMapper(ProductGroupMapper.class);

}
