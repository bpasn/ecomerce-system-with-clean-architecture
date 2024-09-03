package com.app.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.app.application.dto.StoreDTO;
import com.app.domain.entity.StoreEntity;

@Mapper(componentModel = "spring")
public interface StoreMapper extends BaseMapper<StoreDTO, StoreEntity> {
    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);
}
