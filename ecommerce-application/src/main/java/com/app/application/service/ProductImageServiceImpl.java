package com.app.application.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.application.dto.ProductImageDTO;
import com.app.application.handler.CustomExceptionHandler;
import com.app.application.handler.EnumCode;
import com.app.application.interfaces.ProductImageService;
import com.app.application.mapper.ProductImageMapper;
import com.app.domain.entity.ProductImageEntity;
import com.app.infrastructure.repositories.ProductImageJpaRepository;

@Service
public class ProductImageServiceImpl implements ProductImageService {

    private final ProductImageJpaRepository productImageJpaRepository;

    ProductImageServiceImpl(ProductImageJpaRepository productImageJpaRepository) {
        this.productImageJpaRepository = productImageJpaRepository;
    }

    @Override
    public Page<ProductImageDTO> getAll(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        return productImageJpaRepository.findAll(pageable).map(ProductImageMapper.INSTANCE::toDTO);
    }

    @Override
    public ProductImageDTO getById(Long id) {
        return productImageJpaRepository.findById(id).map(ProductImageMapper.INSTANCE::toDTO).orElse(null);
    }

    @Override
    public String create(ProductImageDTO model) {
        productImageJpaRepository.save(ProductImageMapper.INSTANCE.toEntity(model));
        return "ProudctImage has created";
    }

    @Override
    public void createAll(List<ProductImageDTO> models) {
        productImageJpaRepository.saveAll(models.stream().map(ProductImageMapper.INSTANCE::toEntity).toList());
    }

    @Override
    public void update(Long id, ProductImageDTO model) {
        ProductImageEntity entity = productImageJpaRepository.findById(id).orElse(null);
        if(entity == null){
            throw new CustomExceptionHandler("Image with id " + id + " not found", EnumCode.NOT_FOUND);
        }
        entity.setSource(model.getSource());
        entity.setType(model.getType());
        productImageJpaRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        productImageJpaRepository.deleteById(id);
    }

    @Override
    public ProductImageDTO getByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }


}
