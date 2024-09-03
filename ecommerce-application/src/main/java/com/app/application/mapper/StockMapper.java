package com.app.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.app.application.dto.StockDTO;
import com.app.domain.entity.StockEntity;

@Mapper(componentModel = "spring")
public interface StockMapper extends BaseMapper<StockDTO,StockEntity> {
    public StockMapper INSTANCE = Mappers.getMapper(StockMapper.class);
}