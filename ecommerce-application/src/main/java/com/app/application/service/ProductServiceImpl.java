package com.app.application.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.application.ApiResponse;
import com.app.application.dto.CategoriesDTO;
import com.app.application.dto.ProductOptionDTO;
import com.app.application.dto.ProductsDTO;
import com.app.application.interfaces.ProductService;
import com.app.application.mapper.ProductMapper;
import com.app.domain.entity.CategoriesEntity;
import com.app.domain.entity.ProductEntity;
import com.app.domain.entity.ProductImageEntity;
import com.app.domain.entity.ProductOptionEntity;
import com.app.domain.entity.StockEntity;
import com.app.domain.usecase.CategoryUseCase;
import com.app.domain.usecase.ProductImageUseCase;
import com.app.domain.usecase.ProductOptionUseCase;
import com.app.domain.usecase.ProductUseCase;
import com.app.domain.usecase.StockUseCase;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl extends BaseServiceImpl<ProductEntity, ProductsDTO> implements ProductService {

    @Value("${mount-path}")
    private String mountPath;
    private final ProductUseCase productUseCase;
    private final CategoryUseCase categoryUseCase;
    private final ProductOptionUseCase productOptionUseCase;
    private final ProductImageUseCase productImageUseCase;
    private final StockUseCase stockUseCase;

    public ProductServiceImpl(
            ProductUseCase productUseCase,
            ProductImageUseCase productImageUseCase,
            ProductMapper productMapper,
            StockUseCase stockUseCase,
            CategoryUseCase categoryUseCase,
            ProductOptionUseCase productOptionUseCase
            ) {
        super(productUseCase, productMapper);
        this.productUseCase = productUseCase;
        this.productImageUseCase = productImageUseCase;
        this.stockUseCase = stockUseCase;
        this.categoryUseCase = categoryUseCase;
        this.productOptionUseCase = productOptionUseCase;

    }

    @Override
    public ProductsDTO getByName(String name) {
        return ProductMapper.INSTANCE.toDTO(productUseCase.findByNameTH(name).orElse(null));
    }

    @Override
    @Transactional
    public ApiResponse<ProductsDTO> create(ProductsDTO model) {
        // แปลง DTO เป็น Entity
        ProductEntity productEntity = ProductMapper.INSTANCE.toEntity(model);
        System.out.println(productEntity.getProductImages());
        List<CategoriesEntity> pCategoriesEntities = categoryUseCase.findAllById(model.getCategories().stream().map(CategoriesDTO::getId).toList());
        List<ProductOptionEntity> productOptionEntities = productOptionUseCase.findAllById(model.getProductOptions().stream().map(ProductOptionDTO::getId).toList());
        productEntity.setCategories(pCategoriesEntities);
        productEntity.setProductOptions(productOptionEntities);
        // บันทึก StockEntity ก่อน
        ProductEntity savedProduct = productUseCase.insert(productEntity);

        StockEntity stock = productEntity.getStock();
        stock.setProduct(savedProduct);

        System.out.println("Stock : " + stock.toString());
        if (stock != null) {
            StockEntity savedStock = stockUseCase.insert(productEntity.getStock());
            productEntity.setStock(savedStock);
        }

        // บันทึก ProductEntity
        // จัดการกับ ProductImageEntity
        if (!model.getProductImages().isEmpty()) {
            model.getProductImages().forEach(file -> {
                System.out.println("file " + file.toString());
                ProductImageEntity productImageEntity = new ProductImageEntity();
                try {
                    String pathFile = createPathFile(file, productEntity.getId().toString());
                    productImageEntity.setProduct(savedProduct);
                    productImageEntity.setSource(pathFile);
                    productImageUseCase.insert(productImageEntity);
                    productEntity.getProductImages().add(productImageEntity);
                } catch (IOException e) {
                    System.out.println(e);
                    e.printStackTrace();
                }
            });
        }
        
        return new ApiResponse<>(ProductMapper.INSTANCE.toDTO(productEntity));
    }

    public String createPathFile(MultipartFile multipartFile, String id) throws IOException {
        // กำหนดชื่อไฟล์และตำแหน่งในการบันทึก
        Path destination = Paths.get(mountPath + id, multipartFile.getOriginalFilename());

        // สร้างไดเรกทอรีถ้ายังไม่มีอยู่
        if (Files.notExists(destination.getParent())) {
            Files.createDirectories(destination.getParent());
        }

        if (!destination.toFile().exists()) {
            destination.toFile().createNewFile();
        }
        Files.write(destination, multipartFile.getBytes());
        return destination.toString();
    }

}
