package com.app.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.app.domain.models.Stock;
import com.app.infrastructure.entity.StockEntity;

@Mapper(componentModel = "spring")
public interface StockMapperInfra extends GenericMapper<StockEntity,Stock> {
    public StockMapperInfra INSTANCE = Mappers.getMapper(StockMapperInfra.class);
}
