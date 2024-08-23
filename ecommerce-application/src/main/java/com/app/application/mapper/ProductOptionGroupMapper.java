package com.app.application.mapper;

import com.app.application.dto.ProductOptionGroupDTO;
import com.app.domain.entity.ProductOptionGroupEntity;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface ProductOptionGroupMapper extends BaseMapper<ProductOptionGroupDTO, ProductOptionGroupEntity>{
    ProductOptionGroupMapper INSTANCE = Mappers.getMapper(ProductOptionGroupMapper.class);

}
