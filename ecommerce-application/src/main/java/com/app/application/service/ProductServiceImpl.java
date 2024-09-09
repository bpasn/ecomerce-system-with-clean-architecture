package com.app.application.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.application.ApiResponse;
import com.app.application.dto.CategoriesDTO;
import com.app.application.dto.ProductOptionDTO;
import com.app.application.dto.ProductsDTO;
import com.app.application.helper.Utils;
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
import com.app.infrastructure.exception.NotFoundException;

@Service
public class ProductServiceImpl extends BaseServiceImpl<ProductEntity, ProductsDTO> implements ProductService {

    @Value("${mount-path}")
    private String mountPath;
    private final ProductUseCase productUseCase;
    private final CategoryUseCase categoryUseCase;
    private final ProductOptionUseCase productOptionUseCase;
    private final ProductImageUseCase productImageUseCase;
    private final StockUseCase stockUseCase;
    private final Utils utils;
    private final ProductMapper productMapper;

    public ProductServiceImpl(
            ProductUseCase productUseCase,
            ProductImageUseCase productImageUseCase,
            ProductMapper productMapper,
            StockUseCase stockUseCase,
            CategoryUseCase categoryUseCase,
            ProductOptionUseCase productOptionUseCase,
            Utils utils) {
        super(productUseCase, productMapper, ProductEntity.class);
        this.productUseCase = productUseCase;
        this.productImageUseCase = productImageUseCase;
        this.stockUseCase = stockUseCase;
        this.categoryUseCase = categoryUseCase;
        this.productOptionUseCase = productOptionUseCase;
        this.utils = utils;
        this.productMapper = productMapper;

    }

    @Override
    public ProductsDTO getByName(String name) {
        return ProductMapper.INSTANCE.toDTO(productUseCase.findByNameTH(name).orElse(null));
    }

    @Override
    public ApiResponse<ProductsDTO> getById(String id) {

        return new ApiResponse<>(productMapper.toDTO(productUseCase.findById(id).orElse(null)));
    }

    @Override
    public ApiResponse<ProductsDTO> createProduct(List<Object> multipart, ProductsDTO productsDTO) {
        // แปลง DTO เป็น Entity
        ProductEntity productEntity = ProductMapper.INSTANCE.toEntity(productsDTO);
        System.out.println(productEntity.getProductImages());
        List<CategoriesEntity> pCategoriesEntities = categoryUseCase
                .findAllById(productsDTO.getCategories().stream().map(CategoriesDTO::getId).toList());
        List<ProductOptionEntity> productOptionEntities = productOptionUseCase
                .findAllById(productsDTO.getProductOptions().stream().map(ProductOptionDTO::getId).toList());
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
        if (!multipart.isEmpty()) {
            multipart.forEach(file -> {

                System.out.println("file " + file.toString());
                ProductImageEntity productImageEntity = new ProductImageEntity();
                try {
                    if (file instanceof MultipartFile) {
                        String pathFile = utils.createPathFile((MultipartFile) file, productEntity.getId().toString());
                        productImageEntity.setSource(pathFile);
                    }
                    productImageEntity.setProduct(savedProduct);
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
    @Override
    public ApiResponse<ProductsDTO> updateProduct(String id, List<Object> multipart, ProductsDTO productsDTO) {
        ProductEntity productEntity = productUseCase.findById(id).orElseThrow(() -> new NotFoundException("Product", id));
       
        List<CategoriesEntity> pCategoriesEntities = categoryUseCase
                .findAllById(productsDTO.getCategories().stream().map(CategoriesDTO::getId).toList());
        List<ProductOptionEntity> productOptionEntities = productOptionUseCase
                .findAllById(productsDTO.getProductOptions().stream().map(ProductOptionDTO::getId).toList());
        productEntity.setCategories(pCategoriesEntities);
        productEntity.setProductOptions(productOptionEntities);
        // บันทึก StockEntity ก่อน
        ProductEntity savedProduct = productUseCase.update(id, productEntity);

        StockEntity stock = productEntity.getStock();
        stock.setProduct(savedProduct);

        System.out.println("Stock : " + stock.toString());
        if (stock != null) {
            StockEntity savedStock = stockUseCase.update(productEntity.getStock().getId(), productEntity.getStock());
            productEntity.setStock(savedStock);
        }

        // บันทึก ProductEntity
        // จัดการกับ ProductImageEntity
        if (!multipart.isEmpty()) {
            multipart.forEach(file -> {

                System.out.println("file " + file.toString());
                ProductImageEntity productImageEntity = new ProductImageEntity();
                try {
                    if (file instanceof MultipartFile) {
                        String pathFile = utils.createPathFile((MultipartFile) file, productEntity.getId().toString());
                        productImageEntity.setSource(pathFile);
                    }
                    productImageEntity.setProduct(savedProduct);
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

}
