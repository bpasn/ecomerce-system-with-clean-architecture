package com.app.application.mapper;

import com.app.application.dto.ProductImageDTO;
import com.app.domain.entity.ProductImageEntity;

import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductImageMapper extends BaseMapper<ProductImageDTO, ProductImageEntity>{
    ProductImageMapper INSTANCE = Mappers.getMapper(ProductImageMapper.class);
    
}
