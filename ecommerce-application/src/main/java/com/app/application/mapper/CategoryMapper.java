package com.app.application.mapper;

import com.app.application.dto.CategoriesDTO;
import com.app.domain.models.ProductCategories;
import com.app.domain.models.Store;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends BaseMapper<CategoriesDTO,ProductCategories>{
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);


    @Override
    @Mapping(source = "store",target = "storeId",qualifiedByName = "storeToIdString")
    CategoriesDTO toDTO(ProductCategories entity);


    @Named("storeToIdString")
    default String storeToIdString(Store store){
        return store.getId();
    }


}
