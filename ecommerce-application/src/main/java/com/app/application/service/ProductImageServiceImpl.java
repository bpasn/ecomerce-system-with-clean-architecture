package com.app.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.application.dto.ProductImageDTO;
import com.app.application.helper.FileManagement;
import com.app.application.interfaces.ProductImageService;
import com.app.application.mapper.ProductImageMapper;
import com.app.domain.models.ProductImage;
import com.app.domain.usecase.ProductImageUseCase;
import com.app.infrastructure.exception.NotFoundException;

@Service
public class ProductImageServiceImpl extends BaseServiceImpl<ProductImage, ProductImageDTO>
        implements ProductImageService {

            private final ProductImageUseCase productImageUseCase;
            private final FileManagement fileManagement;

    ProductImageServiceImpl(ProductImageUseCase productImageUseCase, ProductImageMapper productImageMapper,FileManagement fileManagement) {
        super(productImageUseCase, productImageMapper,ProductImage.class);
        this.productImageUseCase = productImageUseCase;
        this.fileManagement = fileManagement;
    }

    @Override
    @Transactional
    public void deleteImage(String id) {
       ProductImage productImageEntity = productImageUseCase.findById(id).orElseThrow(() -> new NotFoundException("ProductImage", id));
       fileManagement.removeFile(productImageEntity.getSource());
       productImageUseCase.delete(id);
    }

}
