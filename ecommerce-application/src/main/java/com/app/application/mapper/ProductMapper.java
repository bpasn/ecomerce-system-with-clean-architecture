package com.app.application.mapper;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.web.multipart.MultipartFile;

import com.app.application.dto.ProductImageDTO;
import com.app.application.dto.ProductsDTO;
import com.app.domain.models.Product;
import com.app.domain.models.ProductImage;
import com.app.domain.models.Store;

@Mapper(componentModel = "spring") // Using Spring for dependency injection
public interface ProductMapper extends BaseMapper<ProductsDTO, Product> {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Override
    @Mapping(source = "productImages", target = "productImages", qualifiedByName = "mapProductImageEntityListToDTO")
    @Mapping(source = "store", target = "storeId", qualifiedByName = "storeToStringId")
    ProductsDTO toDTO(Product entity);

    @Override
    @Mapping(source = "productImages", target = "productImages", qualifiedByName = "mapProductImageDTOListToEntity")
    Product toModel(ProductsDTO dto);

    @Named("mapProductImageEntityListToDTO")
    default List<ProductImageDTO> mapProductImageEntityListToDTO(List<ProductImage> entities) {
        // Implement your logic here if needed, otherwise let MapStruct handle it if you
        // have mapping between ProductImageDTO and ProductImageEntity
        return entities.stream()
                .map(entity -> new ProductImageDTO(entity.getId(), entity.getSource())) // Custom mapping logic
                .toList();
    }

    @Named("mapProductImageDTOListToEntity")
    default List<ProductImage> mapProductImageDTOListToEntity(List<ProductImageDTO> productImageDTOs) {
        if (productImageDTOs != null) {
            return productImageDTOs.stream()
                    .map(file -> new ProductImage(file.getId(), file.getUri())).toList();
        }
        return new ArrayList<>();

    }

    @Named("storeToStringId")
    default String storeToStringId(Store store) {
        return store.getId();
    }
}
