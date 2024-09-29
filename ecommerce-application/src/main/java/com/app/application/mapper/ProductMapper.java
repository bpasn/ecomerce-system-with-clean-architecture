package com.app.application.mapper;

import java.util.HashSet;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.app.application.dto.CategoriesDTO;
import com.app.application.dto.ProductImageDTO;
import com.app.application.dto.ProductsDTO;
import com.app.domain.models.Product;
import com.app.domain.models.ProductCategories;
import com.app.domain.models.ProductImage;
import com.app.domain.models.Store;

@Mapper(componentModel = "spring") // Using Spring for dependency injection
public interface ProductMapper extends BaseMapper<ProductsDTO, Product> {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Override
    @Mapping(source = "store.id", target = "storeId")
    @Mapping(source = "productImages", target = "productImages", qualifiedByName = "mapProductImageListToDTO")
    @Mapping(source = "categories", target = "categories", qualifiedByName = "toCategoriesSetDTO")
    ProductsDTO toDTO(Product entity);

    @Override
    @Mapping(source = "productImages", target = "productImages", qualifiedByName = "mapProductImageDTOListToEntity")
    @Mapping(source = "storeId", target = "store.id")
    Product toModel(ProductsDTO dto);

    @Named("toCategoriesSetDTO")
    default Set<CategoriesDTO> toCategoriesSet(Set<ProductCategories> categories) {
        return new HashSet<>(categories.stream().map(e -> addCategoryDTO(e)).toList());
    }

    default CategoriesDTO addCategoryDTO(ProductCategories productCategories) {
        return new CategoriesDTO(productCategories.getId(), productCategories.getName(),
                productCategories.getStore().getId());
    }

    @Named("mapProductImageListToDTO")
    default Set<ProductImageDTO> mapProductImageEntityListToDTO(Set<ProductImage> entities) {
        return new HashSet<>(entities.stream()
                .map(entity -> new ProductImageDTO(entity.getId(), entity.getSource())) // Custom mapping logic
                .toList());
    }

    @Named("mapProductImageDTOListToEntity")
    default Set<ProductImage> mapProductImageDTOListToEntity(Set<ProductImageDTO> productImageDTOs) {
        if (productImageDTOs != null) {
            return new HashSet<>(productImageDTOs.stream()
                    .map(file -> new ProductImage(file.getId(), file.getSource())).toList());
        }
        return new HashSet<>();

    }

    @Named("storeToStringId")
    default String storeToStringId(Store store) {
        return store.getId();
    }
}
