package com.app.application.mapper;

import com.app.application.dto.ProductsDTO;
import com.app.application.dto.ProductImageDTO;
import com.app.domain.entity.ProductEntity;
import com.app.domain.entity.ProductImageEntity;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.mock.web.MockMultipartFile;
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
    default MultipartFile stringToMultipartFile(String filePath) {
        if (filePath == null) {
            return null;
        }
        try {
            Path path = Paths.get(filePath);
            String name = path.getFileName().toString();
            String contentType = Files.probeContentType(path);
            byte[] content = Files.readAllBytes(path);
            System.out.println("PATH : " + content);
            return new MockMultipartFile(name, name, contentType, content);
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
    default List<MultipartFile> mapProductImageEntityListToDTO(List<ProductImageEntity> entities) {
        // Implement your logic here if needed, otherwise let MapStruct handle it if you
        // have mapping between ProductImageDTO and ProductImageEntity
        return entities.stream()
                .map(entity -> stringToMultipartFile(entity.getSource())) // Custom mapping logic
                .toList();
    }

    @Named("mapProductImageDTOListToEntity")
    default List<ProductImageEntity> mapProductImageDTOListToEntity(List<MultipartFile> files) {
        // if (files != null) {
        //     System.out.println(files.size());
        //     return files.stream()
        //             .map(file -> new ProductImageEntity(fileToString(file))).toList();
        // }
        return new ArrayList<>();

    }
}
