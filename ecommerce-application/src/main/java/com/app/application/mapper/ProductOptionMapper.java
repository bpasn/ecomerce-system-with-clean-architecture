package com.app.application.mapper;

import com.app.application.dto.ProductOptionDTO;
import com.app.domain.entity.ProductOptionEntity;

import com.app.domain.entity.StoreEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface ProductOptionMapper extends BaseMapper<ProductOptionDTO, ProductOptionEntity>{
    ProductOptionMapper INSTANCE = Mappers.getMapper(ProductOptionMapper.class);

    @Override
    @Mapping(source = "store",target = "storeId",qualifiedByName = "toIdString")
    ProductOptionDTO toDTO(ProductOptionEntity entity);

    @Named("toIdString")
    default String toIdString(StoreEntity store){
        return store.getId();
    }
}
