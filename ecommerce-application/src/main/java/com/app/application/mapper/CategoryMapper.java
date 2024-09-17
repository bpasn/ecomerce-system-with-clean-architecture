package com.app.application.mapper;

import com.app.application.dto.CategoriesDTO;
import com.app.domain.entity.ProductCategoriesEntity;
import com.app.domain.entity.StoreEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends BaseMapper<CategoriesDTO,ProductCategoriesEntity>{
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);


    @Override
    @Mapping(source = "store",target = "storeId",qualifiedByName = "storeToIdString")
    CategoriesDTO toDTO(ProductCategoriesEntity entity);


    @Named("storeToIdString")
    default String storeToIdString(StoreEntity store){
        return store.getId();
    }


}
