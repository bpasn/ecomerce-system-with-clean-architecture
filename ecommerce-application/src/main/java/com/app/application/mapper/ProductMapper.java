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
import com.app.domain.entity.ProductEntity;
import com.app.domain.entity.ProductImageEntity;
import com.app.domain.entity.StoreEntity;

@Mapper(componentModel = "spring") // Using Spring for dependency injection
public interface ProductMapper extends BaseMapper<ProductsDTO, ProductEntity> {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Override
    @Mapping(source = "productImages", target = "productImages", qualifiedByName = "mapProductImageEntityListToDTO")
    @Mapping(source = "store", target = "storeId", qualifiedByName = "storeToStringId")
    ProductsDTO toDTO(ProductEntity entity);

    @Override
    @Mapping(source = "productImages", target = "productImages", qualifiedByName = "mapProductImageDTOListToEntity")
    ProductEntity toEntity(ProductsDTO dto);

    // @Named("stringToMultipartFile")
    // default String stringToMultipartFile(String filePath) {
    // if (filePath == null) {
    // return null;
    // }
    // try {
    // Path path = Paths.get(filePath);
    // return path.toString();
    // } catch (Exception e) {
    // e.printStackTrace();
    // return null;
    // }
    // }

    // @Named("fileToString")
    // default String fileToString(MultipartFile multipartFile) {
    // return multipartFile != null ? multipartFile.getOriginalFilename() : null;
    // }

    @Named("mapProductImageEntityListToDTO")
    default List<ProductImageDTO> mapProductImageEntityListToDTO(List<ProductImageEntity> entities) {
        // Implement your logic here if needed, otherwise let MapStruct handle it if you
        // have mapping between ProductImageDTO and ProductImageEntity
        return entities.stream()
                .map(entity -> new ProductImageDTO(entity.getId(), entity.getSource())) // Custom mapping logic
                .toList();
    }

    @Named("mapProductImageDTOListToEntity")
    default List<ProductImageEntity> mapProductImageDTOListToEntity(List<ProductImageDTO> productImageDTOs) {
        if (productImageDTOs != null) {
            return productImageDTOs.stream()
                    .map(file -> new ProductImageEntity(file.getId(), file.getUri())).toList();
        }
        return new ArrayList<>();

    }

    @Named("storeToStringId")
    default String storeToStringId(StoreEntity store) {
        return store.getId();
    }
}
