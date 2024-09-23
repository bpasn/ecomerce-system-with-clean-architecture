package com.app.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.app.domain.models.Store;
import com.app.infrastructure.entity.StoreEntity;

@Mapper(componentModel = "spring")
public interface StoreMapperInfra extends GenericMapper<StoreEntity, Store> {
    public StoreMapperInfra INSTANCE = Mappers.getMapper(StoreMapperInfra.class);

    @Override
    @Mapping(target = "user",ignore=true)
    @Mapping(target = "products",ignore=true)
    @Mapping(target = "productCategories",ignore=true)
    @Mapping(target = "productOption",ignore=true)
    StoreEntity toEntity(Store model);

    @Override
    @Mapping(target = "user",ignore=true)
    @Mapping(target = "products",ignore=true)
    @Mapping(target = "productCategories",ignore=true)
    @Mapping(target = "productOption",ignore=true)
    Store toModel(StoreEntity entity);

    
}
