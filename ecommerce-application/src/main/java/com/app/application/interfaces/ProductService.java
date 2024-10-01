package com.app.application.interfaces;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.ProductsDTO;
import com.app.domain.models.Product;
import com.app.domain.pageable.PageResult;
import com.app.domain.projections.StockProductProjection;

public interface ProductService extends BaseService<Product, ProductsDTO> {
    ProductsDTO getByName(String name);

    ApiResponse<ProductsDTO> createProduct(List<MultipartFile> multipart, ProductsDTO productsDTO);

    ApiResponse<ProductsDTO> updateProduct(String productId, List<MultipartFile> files, ProductsDTO productsDTO);

    ApiResponse<PageResult<ProductsDTO>> findAllByStoreIdWithPageable(String storeId, int page, int size);

    ApiResponse<List<ProductsDTO>> getProduct();

    ApiResponse<List<StockProductProjection>> getProductStock(String storeId);

    List<ProductsDTO> getAllById(List<String> ids);

}
