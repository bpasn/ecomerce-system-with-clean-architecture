package com.app.application.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.ProductsDTO;
import com.app.domain.models.Product;
import com.app.domain.pageable.PageResult;

public interface ProductService extends BaseService<Product, ProductsDTO> {
    ProductsDTO getByName(String name);

    ApiResponse<ProductsDTO> createProduct(List<MultipartFile> multipart, ProductsDTO productsDTO);

    ApiResponse<ProductsDTO> updateProduct(String productId, List<MultipartFile> files, ProductsDTO productsDTO);

    ApiResponse<PageResult<ProductsDTO>> findAllByStoreIdWithPageable(String storeId, int page, int size);

    ApiResponse<List<ProductsDTO>> getProduct();

}
