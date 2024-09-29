package com.app.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.app.application.dto.ProductImageDTO;
import com.app.domain.models.ProductImage;

@Mapper(componentModel = "spring")
public interface ProductImageMapper extends BaseMapper<ProductImageDTO, ProductImage> {

    ProductImageMapper INSTANCE = Mappers.getMapper(ProductImageMapper.class);

    // @Named("toStringDTO")
    // default MultipartFile toStringDTO(String source) {
    //     if (filePath == null) {
    //         return null;
    //     }
    //     try {
    //         Path path = Paths.get(filePath);
    //         String name = path.getFileName().toString();
    //         String contentType = Files.probeContentType(path);
    //         byte[] content = Files.readAllBytes(path);
    //         return new CustomMultipartFile(content, name, name, contentType);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return null;
    //     }
    // }

    // @Named("multipartFileToString")
    // default String multipartFileToString(MultipartFile file) {
    //     return file != null ? file.getOriginalFilename() : null; // Mapping file name as String
    // }
}
