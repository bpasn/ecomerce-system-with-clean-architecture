package com.app.application.mapper;

import com.app.application.dto.ProductsDTO;
import com.app.application.helper.CustomMultipartFile;
import com.app.domain.entity.ProductEntity;
import com.app.domain.entity.ProductImageEntity;

import lombok.extern.log4j.Log4j2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.io.File;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.web.multipart.MultipartFile;

@Mapper(componentModel = "spring") // Using Spring for dependency injection
public interface ProductMapper extends BaseMapper<ProductsDTO, ProductEntity> {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Override
    @Mapping(source = "productImages", target = "productImages", qualifiedByName = "mapProductImageEntityListToDTO")
    ProductsDTO toDTO(ProductEntity entity);

    @Override
    @Mapping(source = "productImages", target = "productImages", qualifiedByName = "mapProductImageDTOListToEntity")
    ProductEntity toEntity(ProductsDTO dto);

    @Named("stringToMultipartFile")
    default String stringToMultipartFile(String filePath) {
        if (filePath == null) {
            return null;
        }
        try {
            Path path = Paths.get(filePath);
            return path.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Named("fileToString")
    default String fileToString(MultipartFile multipartFile) {
        return multipartFile != null ? multipartFile.getOriginalFilename() : null;
    }

    @Named("mapProductImageEntityListToDTO")
    default List<String> mapProductImageEntityListToDTO(List<ProductImageEntity> entities) {
        // Implement your logic here if needed, otherwise let MapStruct handle it if you
        // have mapping between ProductImageDTO and ProductImageEntity
        return entities.stream()
                .map(entity -> stringToMultipartFile(entity.getSource())) // Custom mapping logic
                .toList();
    }

    @Named("mapProductImageDTOListToEntity")
    default List<ProductImageEntity> mapProductImageDTOListToEntity(List<String> files) {
        if (files != null) {
        System.out.println(files.size());
        return files.stream()
        .map(file -> new ProductImageEntity(file)).toList();
        }
        return new ArrayList<>();

    }
}
