package com.app.application.service;

import org.springframework.stereotype.Service;

import com.app.application.dto.ProductImageDTO;
import com.app.application.interfaces.ProductImageService;
import com.app.application.mapper.ProductImageMapper;
import com.app.domain.entity.ProductImageEntity;
import com.app.domain.usecase.ProductImageUseCase;

@Service
public class ProductImageServiceImpl extends BaseServiceImpl<ProductImageEntity, ProductImageDTO>
        implements ProductImageService {

    private final ProductImageUseCase productImageUseCase;
    private final ProductImageMapper productImageMapper;

    ProductImageServiceImpl(ProductImageUseCase productImageUseCase, ProductImageMapper productImageMapper) {
        super(productImageUseCase, productImageMapper);
        this.productImageUseCase = productImageUseCase;
        this.productImageMapper = productImageMapper;
    }

}
