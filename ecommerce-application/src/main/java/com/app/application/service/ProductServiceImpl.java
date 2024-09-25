package com.app.application.service;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.CategoriesDTO;
import com.app.application.dto.ProductOptionDTO;
import com.app.application.dto.ProductsDTO;
import com.app.application.helper.FileManagement;
import com.app.application.interfaces.ProductService;
import com.app.application.mapper.ProductMapper;
import com.app.application.mapper.StockMapper;
import com.app.domain.models.Product;
import com.app.domain.models.ProductCategories;
import com.app.domain.models.ProductImage;
import com.app.domain.models.ProductOption;
import com.app.domain.models.Stock;
import com.app.domain.models.Store;
import com.app.domain.pageable.PageResult;
import com.app.domain.projections.StockProductProjection;
import com.app.domain.usecase.ProductCategoryUseCase;
import com.app.domain.usecase.ProductImageUseCase;
import com.app.domain.usecase.ProductOptionUseCase;
import com.app.domain.usecase.ProductUseCase;
import com.app.domain.usecase.StockUseCase;
import com.app.domain.usecase.StoreUseCase;
import com.app.infrastructure.exception.BaseException;
import com.app.infrastructure.exception.NotFoundException;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, ProductsDTO> implements ProductService {

    @Value("${mount-path}")
    private String mountPath;
    private final ProductUseCase productUseCase;
    private final ProductCategoryUseCase categoryUseCase;
    private final ProductOptionUseCase productOptionUseCase;
    private final ProductImageUseCase productImageUseCase;
    private final StockUseCase stockUseCase;
    private final ProductMapper productMapper;
    private final StoreUseCase storeUseCase;
    private final FileManagement fileManagement;

    public ProductServiceImpl(
            ProductUseCase productUseCase,
            ProductImageUseCase productImageUseCase,
            ProductMapper productMapper,
            StockUseCase stockUseCase,
            ProductCategoryUseCase categoryUseCase,
            ProductOptionUseCase productOptionUseCase,
            StoreUseCase storeUseCase,
            FileManagement fileManagement) {
        super(productUseCase, productMapper, Product.class);
        this.productUseCase = productUseCase;
        this.productImageUseCase = productImageUseCase;
        this.stockUseCase = stockUseCase;
        this.categoryUseCase = categoryUseCase;
        this.productOptionUseCase = productOptionUseCase;
        this.productMapper = productMapper;
        this.storeUseCase = storeUseCase;
        this.fileManagement = fileManagement;

    }

    @Override
    public ProductsDTO getByName(String name) {
        return ProductMapper.INSTANCE.toDTO(productUseCase.findByNameTH(name).orElse(null));
    }

    @Override
    @Transactional(rollbackOn = RuntimeException.class)
    public ApiResponse<ProductsDTO> createProduct(List<MultipartFile> multipart, ProductsDTO productsDTO) {
        try {
            // แปลง DTO เป็น Entity
            Product productEntity = ProductMapper.INSTANCE.toModel(productsDTO);

            // Find store for create product to store
            Store storeEntity = storeUseCase.findById(productsDTO.getStoreId())
                    .orElseThrow(() -> new NotFoundException("Store", productsDTO.getStoreId()));


            
            // set store_id in product
            productEntity.setStore(storeEntity);

            if (productsDTO.getCategories() != null) {
                Set<ProductCategories> productCategories = new HashSet<>();
                categoryUseCase.findAllById(productsDTO.getCategories().stream().map(CategoriesDTO::getId).toList()).forEach(pc -> productCategories.add(pc));
                productEntity.setCategories(productCategories);
            }
            if (productsDTO.getProductOptions() != null) {
                List<ProductOption> p = productOptionUseCase.findAllById(productsDTO.getProductOptions().stream().map(ProductOptionDTO::getId).toList());
                productEntity.setProductOptions(new HashSet<>(p));
            }

            // save product first
            Product savedProduct = productUseCase.save(productEntity);

            // get store from product
            Stock stock = StockMapper.INSTANCE.toModel(productsDTO.getStock());
            stock.setProduct(savedProduct);

            if (stock != null && stock.getProduct() != null) {
                // ถ้า productId มีแล้ว จะทำการ save
                stockUseCase.save(stock);
            }

            // บันทึก ProductEntity
            // จัดการกับ ProductImageEntity
            if (multipart != null && !multipart.isEmpty()) {
                multipart.forEach(file -> {
                    productEntity.getProductImages().add(createProductImage(file, savedProduct));
                });
            }

            return new ApiResponse<>(ProductMapper.INSTANCE.toDTO(productEntity));
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ApiResponse<ProductsDTO> getById(String id) {
        return new ApiResponse<>(productMapper.toDTO(productUseCase.findById(id).orElse(null)));
    }

    @Override
    public ApiResponse<PageResult<ProductsDTO>> findAllByStoreIdWithPageable(String storeId, int page, int size) {
        PageResult<Product> cPage = productUseCase.findAllByStoreIdWithPageable(storeId, page, size);
        PageResult<ProductsDTO> p = new PageResult<>(
                cPage.getContent().stream().map(productMapper::toDTO).toList(),
                cPage.getPage(),
                cPage.getSize(),
                cPage.getTotalElement(),
                cPage.getTotalPage());
        return new ApiResponse<>(p);
    }

    @Override
    @Transactional(rollbackOn = RuntimeException.class)
    public ApiResponse<ProductsDTO> updateProduct(String productId, List<MultipartFile> files,
            ProductsDTO productsDTO) {
        // แปลง DTO เป็น Entity
        Product product = productUseCase.findById(productId)
                .orElseThrow(() -> new NotFoundException("Product", productId));

        product.setNameEN(productsDTO.getNameEN());
        product.setNameTH(productsDTO.getNameTH());
        product.setDescriptionTH(productsDTO.getDescriptionTH());
        product.setDescriptionEN(productsDTO.getDescriptionEN());
        product.setPrice(productsDTO.getPrice());

        System.out.println(productsDTO.getProductOptions());
        if (productsDTO.getCategories() != null) {
            List<ProductCategories> pCategoriesEntities = categoryUseCase
                    .findAllById(productsDTO.getCategories().stream().map(CategoriesDTO::getId).toList());
            product.setCategories(new HashSet<>(pCategoriesEntities));
        }else{
            product.setCategories(new HashSet<>());
        }
        if (productsDTO.getProductOptions() != null) {
            List<ProductOption> productOptionEntities = productOptionUseCase
                    .findAllById(productsDTO.getProductOptions().stream().map(ProductOptionDTO::getId).toList());
            product.setProductOptions(new HashSet<>(productOptionEntities));
        }else{
            product.setProductOptions(new HashSet<>());
        }

        System.out.println(product);
        productUseCase.save(product);

        Stock stock = StockMapper.INSTANCE.toModel(productsDTO.getStock());
        stock.setId(productsDTO.getStock().getId());
        stock.setProduct(product);

        stockUseCase.save(stock);

        // บันทึก ProductEntity
        // จัดการกับ ProductImageEntity
        if (files != null && !files.isEmpty()) {
            files.forEach(file -> {
                product.getProductImages().add(createProductImage(file, product));
            });
        }

        return new ApiResponse<>(productMapper.toDTO(product));
    }

    public ProductImage createProductImage(MultipartFile file, Product product) {
        ProductImage productImageEntity = new ProductImage();
        try {
            String pathFile = fileManagement.createPathFile(file, product.getId());
            productImageEntity.setProduct(product);
            productImageEntity.setSource(pathFile);
            productImageUseCase.save(productImageEntity);
            return productImageEntity;
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(String id) {
        Product product = productUseCase.findById(id)
                .orElseThrow(() -> new NotFoundException("Product", id));

        for (ProductImage productImageEntity : product.getProductImages()) {
            fileManagement.removeFile(productImageEntity.getSource());
            productImageUseCase.delete(productImageEntity.getId());
        }
        
        stockUseCase.delete(product.getStock().getId());
        productUseCase.delete(id);
    }

    @Override
    public ApiResponse<List<ProductsDTO>> getProduct() {
        return new ApiResponse<>(productUseCase.findAll().stream().map(productMapper::toDTO).toList());
    }

    @Override
    public ApiResponse<List<StockProductProjection>> getProductStock(String storeId) {
       List<StockProductProjection> stockProductProjections =productUseCase.findProductStockAllByStoreIdNative(storeId);

        stockProductProjections.stream().map((stock) -> {
            
            return stock;
        });
       return new ApiResponse<>(stockProductProjections);
    }
}
