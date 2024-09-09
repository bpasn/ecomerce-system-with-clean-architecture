package com.app.application.interfaces;

import java.util.List;

import com.app.application.ApiResponse;
import com.app.application.dto.ProductsDTO;
import com.app.domain.entity.ProductEntity;

public interface ProductService extends BaseService<ProductEntity,ProductsDTO>{
    ProductsDTO getByName(String name);
    ApiResponse<ProductsDTO> createProduct(List<Object> multipart,ProductsDTO productsDTO);
    ApiResponse<ProductsDTO> updateProduct(String id,List<Object> multipart,ProductsDTO productsDTO);
}
