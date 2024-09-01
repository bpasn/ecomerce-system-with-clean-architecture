package com.app.application.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.app.application.dto.ProductImageDTO;
import com.app.application.interfaces.ProductImageService;
import com.app.application.mapper.ProductImageMapper;
import com.app.application.mapper.ProductMapper;
import com.app.domain.entity.ProductImageEntity;
import com.app.domain.exceptions.CustomExceptionHandler;
import com.app.domain.exceptions.EnumCode;
import com.app.domain.usecase.ProductImageUseCase;

@Service
public class ProductImageServiceImpl implements ProductImageService {

    private final ProductImageUseCase productImageUseCase;

    ProductImageServiceImpl(ProductImageUseCase productImageUseCase) {
        this.productImageUseCase = productImageUseCase;
    }

    @Override
    public Page<ProductImageDTO> getAllWithPage(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllWithPage'");
    }
    @Override
    public List<ProductImageDTO> getAll() {
        return productImageUseCase.findAll().stream().map(ProductImageMapper.INSTANCE::toDTO).toList();
    }

    @Override
    public ProductImageDTO getById(Long id) {
        return productImageUseCase.findById(id).map(ProductImageMapper.INSTANCE::toDTO).orElse(null);
    }

    @Override
    public ProductImageDTO create(ProductImageDTO model) {
        ProductImageEntity entity = ProductImageMapper.INSTANCE.toEntity(model);
        
        return ProductImageMapper.INSTANCE.toDTO(productImageUseCase.insert(entity));
    }

    @Override
    public void createAll(List<ProductImageDTO> models) {
        List<ProductImageEntity> entities = models.stream().map(ProductImageMapper.INSTANCE::toEntity).toList();
        productImageUseCase.insertAll(entities);
    }

    @Override
    public void update(Long id, ProductImageDTO model) {
        ProductImageEntity entity = productImageUseCase.findById(id).orElse(null);
        if (entity == null) {
            throw new CustomExceptionHandler("Image with id " + id + " not found", EnumCode.NOT_FOUND);
        }
        entity.setSource(ProductMapper.INSTANCE.fileToString(model.getSource()));
        productImageUseCase.insert(entity);
    }

    @Override
    public void delete(Long id) {
        productImageUseCase.delete(id);
    }
   

}
