package com.app.application.interfaces;

import com.app.application.dto.ProductImageDTO;
import com.app.domain.entity.ProductImageEntity;
public interface ProductImageService extends BaseService<ProductImageEntity,ProductImageDTO> {
    void deleteImage(String id);
}
