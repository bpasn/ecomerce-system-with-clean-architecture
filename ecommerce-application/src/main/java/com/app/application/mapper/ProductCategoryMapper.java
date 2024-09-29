package com.app.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.context.properties.bind.Name;

import com.app.application.dto.CategoriesDTO;
import com.app.application.dto.CategoryWithProductDTO;
import com.app.application.dto.ProductsDTO;
import com.app.domain.models.Product;
import com.app.domain.models.ProductCategories;
import com.app.domain.projections.CategoryWithProductProjection;
import java.util.List;
@Mapper(componentModel = "spring")
public interface ProductCategoryMapper extends BaseMapper<CategoriesDTO, ProductCategories> {
    ProductCategoryMapper INSTANCE = Mappers.getMapper(ProductCategoryMapper.class);

    @Override
    @Mapping(source = "store.id", target = "storeId")
    CategoriesDTO toDTO(ProductCategories entity);

    CategoryWithProductDTO toCategoryWithProductDTO(CategoryWithProductProjection pCategories);
}
