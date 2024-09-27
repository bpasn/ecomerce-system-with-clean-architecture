package com.app.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.app.domain.models.Stock;
import com.app.infrastructure.entity.StockEntity;

@Mapper(componentModel = "spring")
public interface StockMapperInfra extends GenericMapper<StockEntity,Stock> {
    public StockMapperInfra INSTANCE = Mappers.getMapper(StockMapperInfra.class);

   @Override
   @Mapping(target = "product",ignore = true)
   Stock toModel(StockEntity stockEntity);

   @Override
    @Mapping(target = "product.stock",ignore = true)
    @Mapping(target = "product.productImages",ignore = true)
    StockEntity toEntity(Stock model);
}
