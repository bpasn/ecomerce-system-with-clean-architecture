package com.app.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.application.dto.CategoriesDTO;
import com.app.application.dto.ProductOptionGroupDTO;
import com.app.application.dto.ProductsDTO;
import com.app.application.interfaces.ProductService;
import com.app.application.mapper.CategoryMapper;
import com.app.application.mapper.ProductImageMapper;
import com.app.application.mapper.ProductMapper;
import com.app.application.mapper.ProductOptionGroupMapper;
import com.app.domain.entity.CategoriesEntity;
import com.app.domain.entity.ProductEntity;
import com.app.domain.entity.ProductImageEntity;
import com.app.domain.entity.ProductOptionGroupEntity;
import com.app.infrastructure.repositories.ProductJpaRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductJpaRepository productRepository;
    private final CategoriesServiceImpl categoriesServiceImpl;
    private final ProductOptionGroupServiceImpl productOptionGroupServiceImpl;
    private final ProductImageServiceImpl productImageServiceImpl;

    ProductServiceImpl(
            ProductJpaRepository productRepository,
            CategoriesServiceImpl categoriesServiceImpl,
            ProductOptionGroupServiceImpl productOptionGroupServiceImpl,
            ProductImageServiceImpl productImageServiceImpl) {
        this.productRepository = productRepository;
        this.categoriesServiceImpl = categoriesServiceImpl;
        this.productOptionGroupServiceImpl = productOptionGroupServiceImpl;
        this.productImageServiceImpl = productImageServiceImpl;
    }


    @Override
    public ProductsDTO getById(Long id) {
        return productRepository.findById(id).map(ProductMapper.INSTANCE::toDTO).orElse(null);
    }

    @Override
    @Transactional
    public String create(ProductsDTO model) {
        List<CategoriesEntity> categoriesEntity = new ArrayList<>();
        for (CategoriesDTO c : model.getCategories()) {
            CategoriesDTO ceEntity = categoriesServiceImpl.getByName(c.getName());
            categoriesEntity.add(CategoryMapper.INSTANCE.toEntity(ceEntity));
        }

        List<ProductOptionGroupEntity> productOptionGroupEntities = new ArrayList<>();
        for (ProductOptionGroupDTO p : model.getProductOptionGroups()) {
            ProductOptionGroupDTO pogeEntity = productOptionGroupServiceImpl.getByName(p.getGroupName());
            productOptionGroupEntities.add(ProductOptionGroupMapper.INSTANCE.toEntity(pogeEntity));
            
        }


        List<ProductImageEntity> productImageEntities = model.getProductImages().stream()
                .map((p) -> new ProductImageEntity(null, p.getSource(), p.getType())).toList();
        productImageServiceImpl.createAll(productImageEntities.stream().map(ProductImageMapper.INSTANCE::toDTO).toList());
        
        ProductEntity productEntity = new ProductEntity(
                model.getName(),
                model.getDescription(),
                model.getPrice(),
                model.getQuantity(),
                categoriesEntity,
                productImageEntities,
                productOptionGroupEntities
        );
        productRepository.save(productEntity);
        return "Product created";
    }

    @Override
    public void update(Long id, ProductsDTO model) {
        ProductEntity productEntity = productRepository.findById(id).orElse(null);
        if (productEntity == null) {
            throw new RuntimeException("Product with id " + id + " not found");
        }
        productEntity.setName(model.getName());
        productEntity.setDescription(model.getDescription());
        productEntity.setPrice(model.getPrice());
        productEntity.setQuantity(model.getQuantity());
        productRepository.save(productEntity);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<ProductsDTO> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductsDTO> productsDTO = productRepository.findAll(pageable).map(ProductMapper.INSTANCE::toDTO);
        return productsDTO;
    }

    @Override
    @Transactional
    public void createAll(List<ProductsDTO> models) {
        productRepository.saveAll(models.stream().map(ProductMapper.INSTANCE::toEntity).toList());
    }


    @Override
    public ProductsDTO getByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }

}
