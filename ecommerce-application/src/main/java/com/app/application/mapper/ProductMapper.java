package com.app.application.mapper;

import com.app.application.dto.ProductsDTO;
import com.app.domain.entity.ProductEntity;

import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ProductMapper extends BaseMapper<ProductsDTO, ProductEntity>{
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    

}
