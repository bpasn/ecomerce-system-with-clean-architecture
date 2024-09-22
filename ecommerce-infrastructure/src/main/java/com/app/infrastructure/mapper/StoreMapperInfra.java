package com.app.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.app.domain.models.Store;
import com.app.infrastructure.entity.StoreEntity;

@Mapper(componentModel = "spring")
public interface StoreMapperInfra extends GenericMapper<StoreEntity, Store> {
    public StoreMapperInfra INSTANCE = Mappers.getMapper(StoreMapperInfra.class);
}
