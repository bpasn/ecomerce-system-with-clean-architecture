package com.app.ecommerce.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.CategoriesDTO;
import com.app.application.dto.ProductOptionDTO;
import com.app.application.dto.ProductsDTO;
import com.app.application.dto.StockDTO;
import com.app.application.helper.FileManagement;
import com.app.application.mapper.ProductMapper;
import com.app.application.mapper.StockMapper;
import com.app.application.service.ProductServiceImpl;
import com.app.domain.models.EStatusStock;
import com.app.domain.models.EUnitType;
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
import com.app.infrastructure.exception.NotFoundException;

@SpringBootTest
class ProductServiceImplTest {

    @Mock
    private ProductUseCase productUseCase;

    @Mock
    private ProductCategoryUseCase categoryUseCase;

    @Mock
    private ProductOptionUseCase productOptionUseCase;

    @Mock
    private ProductImageUseCase productImageUseCase;

    @Mock
    private StockUseCase stockUseCase;

    @Mock
    private StoreUseCase storeUseCase;

    @Mock
    private FileManagement fileManagement;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetByName() {
        // Mock data
        String productName = "Test Product";
        Product product = new Product();
        product.setNameTH(productName);

        // Mock behavior
        when(productUseCase.findByNameTH(productName)).thenReturn(Optional.of(product));

        // Call the service method
        ProductsDTO result = productService.getByName(productName);

        // Verify the results
        assertNotNull(result);
        assertEquals(productName, result.getNameTH());
    }

    @Test
    void testCreateProduct() throws IOException {
        // Mock data
        List<MultipartFile> mockMultipart = new ArrayList<>();
        MultipartFile file1 = mock(MultipartFile.class);
        mockMultipart.add(file1);

        ProductsDTO productsDTO = new ProductsDTO();
        productsDTO.setNameEN("Test Product");
        productsDTO.setNameTH("สินค้าทดสอบ");
        productsDTO.setDescriptionEN("Test Description");
        productsDTO.setDescriptionTH("รายละเอียดสินค้าทดสอบ");
        productsDTO.setPrice(new BigDecimal("100.00"));
        productsDTO.setStoreId("store-id-123");

        // List<CategoriesDTO> categories = new ArrayList<>();
        // categories.add(new CategoriesDTO("category-id-1", "Category 1"));
        // productsDTO.setCategories(new HashSet<>(categories));

        // List<ProductOptionDTO> productOptions = new ArrayList<>();
        // productOptions.add(new ProductOptionDTO("option-id-1", "Option 1", false, false, 0,
        //         new HashSet<>()));
        // productsDTO.setProductOptions(new HashSet<>(productOptions));

        StockDTO stockDTO = new StockDTO();
        stockDTO.setQuantity(100);
        productsDTO.setStock(stockDTO);

        Product productEntity = ProductMapper.INSTANCE.toModel(productsDTO);
        Store storeEntity = new Store();
        storeEntity.setId("store-id-123");

        Product savedProduct = new Product();
        savedProduct.setId("product-id-123");

        Stock stock = StockMapper.INSTANCE.toModel(productsDTO.getStock());
        stock.setProduct(savedProduct);

        ProductImage productImageEntity = new ProductImage();
        productImageEntity.setId("image-id-123");

        // Mock behavior
        when(storeUseCase.findById(productsDTO.getStoreId())).thenReturn(Optional.of(storeEntity));
        when(categoryUseCase.findAllById(any())).thenReturn(new ArrayList<>());
        when(productOptionUseCase.findAllById(any())).thenReturn(new ArrayList<>());
        when(productUseCase.save(any(Product.class))).thenReturn(savedProduct);
        when(stockUseCase.save(any(Stock.class))).thenReturn(stock);
        when(fileManagement.createPathFile(any(MultipartFile.class), any(String.class))).thenReturn("test-path");
        when(productImageUseCase.save(any(ProductImage.class))).thenReturn(productImageEntity);

        // Call the service method
        ApiResponse<ProductsDTO> result = productService.createProduct(mockMultipart, productsDTO);

        // Verify the results
        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatus());
        assertNotNull(result.getPayload());
        assertEquals("product-id-123", result.getPayload().getId());

        // Verify the interactions with the mocks
        verify(storeUseCase, times(1)).findById(productsDTO.getStoreId());
        verify(categoryUseCase, times(1)).findAllById(any());
        verify(productOptionUseCase, times(1)).findAllById(any());
        verify(productUseCase, times(1)).save(any(Product.class));
        verify(stockUseCase, times(1)).save(any(Stock.class));
        verify(fileManagement, times(1)).createPathFile(any(MultipartFile.class), any(String.class));
        verify(productImageUseCase, times(1)).save(any(ProductImage.class));
    }

    @Test
    void testGetById() {
        // Mock data
        String productId = "product-id-123";
        Product product = new Product();
        product.setId(productId);

        // Mock behavior
        when(productUseCase.findById(productId)).thenReturn(Optional.of(product));

        // Call the service method
        ApiResponse<ProductsDTO> result = productService.getById(productId);

        // Verify the results
        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatus());
        assertNotNull(result.getPayload());
        assertEquals(productId, result.getPayload().getId());
    }

    @Test
    void testFindAllByStoreIdWithPageable() {
        // Mock data
        String storeId = "store-id-123";
        int page = 0;
        int size = 10;
        List<Product> products = new ArrayList<>();
        products.add(new Product());
        products.add(new Product());
        PageResult<Product> pageResult = new PageResult<>(products, page, size, products.size(), 1);

        // Mock behavior
        when(productUseCase.findAllByStoreIdWithPageable(storeId, page, size)).thenReturn(pageResult);

        // Call the service method
        ApiResponse<PageResult<ProductsDTO>> result = productService.findAllByStoreIdWithPageable(storeId, page, size);

        // Verify the results
        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatus());
        assertNotNull(result.getPayload());
        assertEquals(products.size(), result.getPayload().getContent().size());
    }

    @Test
    void testUpdateProduct() throws IOException {
        String productId = UUID.randomUUID().toString();
        String categoryId = UUID.randomUUID().toString();
        String optionId = UUID.randomUUID().toString();
        // Mock Data
        List<MultipartFile> mockMultipart = new ArrayList<>();
        MultipartFile file1 = mock(MockMultipartFile.class);
        mockMultipart.add(file1);

        ProductsDTO productsDTO = new ProductsDTO();
        productsDTO.setNameEN("Test Product");
        productsDTO.setNameTH("สินค้าทดสอบ");
        productsDTO.setDescriptionEN("Test Description");
        productsDTO.setDescriptionTH("รายละเอียดสินค้าทดสอบ");
        productsDTO.setPrice(new BigDecimal("100.00"));
        productsDTO.setStoreId("store-id-123");
        // productsDTO.setCategories(new HashSet<>(List.of(new CategoriesDTO(categoryId, "category"))));
        // productsDTO.setProductOptions(
        //         new HashSet<>(List.of(new ProductOptionDTO(optionId, "option", false, false, 0, new HashSet<>()))));

        StockDTO stockDTO = new StockDTO();
        stockDTO.setId("stock-id-123");
        stockDTO.setQuantity(100);
        productsDTO.setStock(stockDTO);

        Product productEntity = ProductMapper.INSTANCE.toModel(productsDTO);
        productEntity.setId(productId);

        ProductCategories productCategories = new ProductCategories();
        productCategories.setId(categoryId);

        ProductOption productOption = new ProductOption();
        productOption.setId(optionId);

        Store storeEntity = new Store();
        storeEntity.setId("store-id-123");

        Product savedProduct = new Product();
        savedProduct.setId(productId);

        Stock stock = StockMapper.INSTANCE.toModel(productsDTO.getStock());
        stock.setProduct(savedProduct);
        stock.setId(stockDTO.getId());

        ProductImage productImageEntity = new ProductImage();
        productImageEntity.setId("image-id-123");

        // Mock behavior
        when(productUseCase.findById(productId)).thenReturn(Optional.of(productEntity));
        when(categoryUseCase.findAllById(any())).thenReturn(List.of(productCategories));
        when(productOptionUseCase.findAllById(any())).thenReturn(List.of(productOption));
        when(productUseCase.save(any(Product.class))).thenReturn(savedProduct);
        when(stockUseCase.save(any(Stock.class))).thenReturn(stock);
        when(fileManagement.createPathFile(any(MockMultipartFile.class), any(String.class))).thenReturn("test-path");
        when(productImageUseCase.save(any(ProductImage.class))).thenReturn(productImageEntity);

        // Call the service method
        ApiResponse<ProductsDTO> result = productService.updateProduct(productId, mockMultipart, productsDTO);

        // Verify the results
        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatus());
        assertNotNull(result.getPayload());
        assertEquals(productId, result.getPayload().getId());

        // Verify the interactions with the mocks
        verify(productUseCase, times(1)).findById(productId);
        verify(categoryUseCase, times(1)).findAllById(any());
        verify(productOptionUseCase, times(1)).findAllById(any());
        verify(productUseCase, times(1)).save(any(Product.class));
        verify(stockUseCase, times(1)).save(any(Stock.class));
        verify(fileManagement, times(1)).createPathFile(any(MockMultipartFile.class), any(String.class));
        verify(productImageUseCase, times(1)).save(any(ProductImage.class));
    }

    @Test
    void testUpdateProductNotFound() throws IOException {
        String productId = UUID.randomUUID().toString();
        // Mock Data
        List<MultipartFile> mockMultipart = new ArrayList<>();
        MultipartFile file1 = mock(MockMultipartFile.class);
        mockMultipart.add(file1);

        ProductsDTO productsDTO = new ProductsDTO();
        productsDTO.setNameEN("Test Product");
        productsDTO.setNameTH("สินค้าทดสอบ");
        productsDTO.setDescriptionEN("Test Description");
        productsDTO.setDescriptionTH("รายละเอียดสินค้าทดสอบ");
        productsDTO.setPrice(new BigDecimal("100.00"));
        productsDTO.setStoreId("store-id-123");

        StockDTO stockDTO = new StockDTO();
        stockDTO.setId("stock-id-123");
        stockDTO.setQuantity(100);
        productsDTO.setStock(stockDTO);

        // Mock behavior
        when(productUseCase.findById(productId)).thenReturn(Optional.empty());

        // Call the service method
        assertThrows(NotFoundException.class,
                () -> productService.updateProduct(productId, mockMultipart, productsDTO));
    }

    @Test
    void testDelete() {
        // Mock data
        String productId = "product-id-123";
        Product product = new Product();
        product.setId(productId);
        Stock stock = new Stock();
        stock.setId("stock-id-123");
        product.setStock(stock);
        ProductImage productImage = new ProductImage();
        productImage.setId("image-id-123");
        product.setProductImages(Set.of(productImage));

        // Mock behavior
        when(productUseCase.findById(productId)).thenReturn(Optional.of(product));
        doNothing().when(fileManagement).removeFile(any(String.class));
        doNothing().when(productImageUseCase).delete(any(String.class));
        doNothing().when(stockUseCase).delete(any(String.class));
        doNothing().when(productUseCase).delete(any(String.class));

        // Call the service method
        productService.delete(productId);

        // Verify the interactions with the mocks
        verify(productUseCase, times(1)).findById(productId);
        verify(fileManagement, times(1)).removeFile(any(String.class));
        verify(productImageUseCase, times(1)).delete(any(String.class));
        verify(stockUseCase, times(1)).delete(any(String.class));
        verify(productUseCase, times(1)).delete(any(String.class));
    }

    @Test
    void testGetProduct() {
        // Mock data
        List<Product> products = new ArrayList<>();
        products.add(new Product());
        products.add(new Product());

        // Mock behavior
        when(productUseCase.findAll()).thenReturn(products);

        // Call the service method
        ApiResponse<List<ProductsDTO>> result = productService.getProduct();

        // Verify the results
        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatus());
        assertNotNull(result.getPayload());
        assertEquals(products.size(), result.getPayload().size());
    }

    @Test
    void testGetProductStock() {
        // Mock data
        String storeId = "store-id-123";
        List<StockProductProjection> stockProductProjections = new ArrayList<>();
        stockProductProjections.add(new StockProductProjection() {
            @Override
            public String getProductId() {
                return "product-id-1";
            };

            @Override
            public String getProductName() {
                return "product-name";
            }

            @Override
            public String getProductImage() {
                return "product-image";
            }

            @Override
            public BigDecimal getProductPrice() {
                return new BigDecimal(10);
            }

            @Override
            public LocalDateTime getProductCreated() {
                return LocalDateTime.now();
            }

            @Override
            public LocalDateTime getProductUpdated() {
                return LocalDateTime.now();
            }

            @Override
            public String getStockId() {
                return "";
            }

            @Override
            public Integer getUnitQuantity() {
                return 1;
            }

            @Override
            public EUnitType getUnitType() {
                return EUnitType.PIECE;
            }

            @Override
            public EStatusStock getStockStatus() {
                return EStatusStock.IN_STOCK;
            }

            @Override
            public Integer getQuantity() {
                return 10;
            }

        });

        // Mock behavior
        when(productUseCase.findProductStockAllByStoreIdNative(storeId)).thenReturn(stockProductProjections);

        // Call the service method
        ApiResponse<List<StockProductProjection>> result = productService.getProductStock(storeId);

        // Verify the results
        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatus());
        assertNotNull(result.getPayload());
        assertEquals(stockProductProjections.size(), result.getPayload().size());
    }
}
