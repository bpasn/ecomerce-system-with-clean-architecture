package com.app.application.mapper;

import com.app.application.dto.ProductOptionDTO;
import com.app.domain.models.ProductOption;
import com.app.domain.models.Store;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface ProductOptionMapper extends BaseMapper<ProductOptionDTO, ProductOption>{
    ProductOptionMapper INSTANCE = Mappers.getMapper(ProductOptionMapper.class);

    @Override
    @Mapping(source = "store",target = "storeId",qualifiedByName = "toIdString")
    ProductOptionDTO toDTO(ProductOption entity);

    @Named("toIdString")
    default String toIdString(Store store){
        return store.getId();
    }
}
