package com.app.application.interfaces;

import com.app.application.dto.ProductImageDTO;
import com.app.domain.models.ProductImage;
public interface ProductImageService extends BaseService<ProductImage,ProductImageDTO> {
    void deleteImage(String id);
}
