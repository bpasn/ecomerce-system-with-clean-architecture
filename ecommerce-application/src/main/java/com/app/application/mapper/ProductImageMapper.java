package com.app.application.mapper;

import com.app.application.dto.ProductImageDTO;
import com.app.application.helper.CustomMultipartFile;
import com.app.domain.entity.ProductImageEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Mapper(componentModel = "spring")
public interface ProductImageMapper extends BaseMapper<ProductImageDTO, ProductImageEntity> {

    ProductImageMapper INSTANCE = Mappers.getMapper(ProductImageMapper.class);

    @Override
    @Mapping(target = "source", source = "source", qualifiedByName = "stringToMultipartFile")
    ProductImageDTO toDTO(ProductImageEntity entity);

    @Override
    @Mapping(target = "source", source = "source", qualifiedByName = "multipartFileToString")
    ProductImageEntity toEntity(ProductImageDTO dto);

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
            return new CustomMultipartFile(content, name, name, contentType);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Named("multipartFileToString")
    default String multipartFileToString(MultipartFile file) {
        return file != null ? file.getOriginalFilename() : null; // Mapping file name as String
    }
}
