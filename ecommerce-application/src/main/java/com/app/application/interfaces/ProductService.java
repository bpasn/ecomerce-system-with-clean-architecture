package com.app.application.interfaces;


import java.util.Optional;

import org.springframework.data.domain.Page;

import com.app.application.dto.ProductsDTO;
import com.app.domain.entity.ProductEntity;

public interface ProductService extends BaseService<ProductEntity,ProductsDTO>{
}
