package com.app.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.app.domain.models.ProductOption;
import com.app.infrastructure.entity.ProductOptionEntity;
@Mapper(componentModel = "spring")
public interface ProductOptionMapperInfra extends GenericMapper<ProductOptionEntity, ProductOption>{
    ProductOptionMapperInfra INSTANCE = Mappers.getMapper(ProductOptionMapperInfra.class);

}
