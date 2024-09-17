package com.app.application.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.CategoriesDTO;
import com.app.application.dto.ProductOptionDTO;
import com.app.application.dto.ProductsDTO;
import com.app.application.interfaces.ProductService;
import com.app.application.mapper.ProductMapper;
import com.app.domain.entity.ProductCategoriesEntity;
import com.app.domain.entity.ProductEntity;
import com.app.domain.entity.ProductImageEntity;
import com.app.domain.entity.ProductOptionEntity;
import com.app.domain.entity.StockEntity;
import com.app.domain.entity.StoreEntity;
import com.app.domain.usecase.ProductCategoryUseCase;
import com.app.domain.usecase.ProductImageUseCase;
import com.app.domain.usecase.ProductOptionUseCase;
import com.app.domain.usecase.ProductUseCase;
import com.app.domain.usecase.StockUseCase;
import com.app.domain.usecase.StoreUseCase;
import com.app.infrastructure.exception.NotFoundException;

@Service
public class ProductServiceImpl extends BaseServiceImpl<ProductEntity, ProductsDTO> implements ProductService {

    @Value("${mount-path}")
    private String mountPath;
    private final ProductUseCase productUseCase;
    private final ProductCategoryUseCase categoryUseCase;
    private final ProductOptionUseCase productOptionUseCase;
    private final ProductImageUseCase productImageUseCase;
    private final StockUseCase stockUseCase;
    private final ProductMapper productMapper;
    private final StoreUseCase storeUseCase;

    public ProductServiceImpl(
            ProductUseCase productUseCase,
            ProductImageUseCase productImageUseCase,
            ProductMapper productMapper,
            StockUseCase stockUseCase,
            ProductCategoryUseCase categoryUseCase,
            ProductOptionUseCase productOptionUseCase,
            StoreUseCase storeUseCase) {
        super(productUseCase, productMapper, ProductEntity.class);
        this.productUseCase = productUseCase;
        this.productImageUseCase = productImageUseCase;
        this.stockUseCase = stockUseCase;
        this.categoryUseCase = categoryUseCase;
        this.productOptionUseCase = productOptionUseCase;
        this.productMapper = productMapper;
        this.storeUseCase = storeUseCase;

    }

    @Override
    public ProductsDTO getByName(String name) {
        return ProductMapper.INSTANCE.toDTO(productUseCase.findByNameTH(name).orElse(null));
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
        return String.format("images/%s/%s", id, multipartFile.getOriginalFilename());
    }

    @Override
    public ApiResponse<ProductsDTO> createProduct(List<MultipartFile> multipart, ProductsDTO productsDTO) {
        // แปลง DTO เป็น Entity
        ProductEntity productEntity = ProductMapper.INSTANCE.toEntity(productsDTO);
        StoreEntity storeEntity = storeUseCase.findById(productsDTO.getStoreId())
                .orElseThrow(() -> new NotFoundException("Store", productsDTO.getStoreId()));
        productEntity.setStore(storeEntity);
        List<ProductCategoriesEntity> pCategoriesEntities = categoryUseCase
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

    @Override
    public ApiResponse<ProductsDTO> getById(String id) {
        return new ApiResponse<>(productMapper.toDTO(productUseCase.findById(id).orElse(null)));
    }

    @Override
    public ApiResponse<Page<ProductsDTO>> findAllByStoreIdWithPageable(String storeId, int page, int size) {
        Page<ProductEntity> cPage = productUseCase.findAllByStoreIdWithPageable(storeId, page, size);
        return new ApiResponse<>(cPage.map(productMapper::toDTO));
    }
}
