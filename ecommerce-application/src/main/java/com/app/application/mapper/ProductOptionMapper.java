package com.app.application.mapper;

import com.app.application.dto.ProductOptionDTO;
import com.app.domain.entity.ProductOptionEntity;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface ProductOptionMapper extends BaseMapper<ProductOptionDTO, ProductOptionEntity>{
    ProductOptionMapper INSTANCE = Mappers.getMapper(ProductOptionMapper.class);

}
