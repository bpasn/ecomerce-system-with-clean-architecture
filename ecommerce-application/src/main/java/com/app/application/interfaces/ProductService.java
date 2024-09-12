package com.app.application.interfaces;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.ProductsDTO;
import com.app.domain.entity.ProductEntity;

public interface ProductService extends BaseService<ProductEntity,ProductsDTO>{
    ProductsDTO getByName(String name);
    ApiResponse<ProductsDTO> createProduct(List<MultipartFile> multipart,ProductsDTO productsDTO);
}
