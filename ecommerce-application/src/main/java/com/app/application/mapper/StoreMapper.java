package com.app.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.app.application.dto.StoreDTO;
import com.app.domain.models.Store;

@Mapper(componentModel = "spring")
public interface StoreMapper extends BaseMapper<StoreDTO, Store> {
    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);

    @Override
    @Mapping(source = "user.id",target = "userId")
    StoreDTO toDTO(Store e);
    
}
