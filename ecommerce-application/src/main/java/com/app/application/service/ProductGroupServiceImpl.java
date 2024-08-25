package com.app.application.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.application.dto.ProductGroupDTO;
import com.app.application.interfaces.ProductGroupService;
import com.app.application.interfaces.ProductOptionService;
import com.app.application.mapper.ProductGroupMapper;
import com.app.domain.entity.ProductGroupEntity;
import com.app.domain.entity.ProductOptionEntity;
import com.app.domain.exceptions.CustomExceptionHandler;
import com.app.domain.exceptions.EnumCode;
import com.app.domain.usecase.ProductGroupUseCase;
import com.app.infrastructure.repositories.ProductGroupJpaRepository;

@Service
public class ProductGroupServiceImpl implements ProductGroupService {
    private final ProductOptionService productOptionService;
    private final ProductGroupJpaRepository productGroupJpaRepository;
private final ProductGroupUseCase productGroupUseCase;
    ProductGroupServiceImpl(
            ProductGroupJpaRepository productGroupJpaRepository,
            ProductOptionService productOptionService,
            ProductGroupUseCase productGroupUseCase) {
        this.productGroupJpaRepository = productGroupJpaRepository;
        this.productOptionService = productOptionService;
        this.productGroupUseCase = productGroupUseCase;
    }

    @Override
    public ProductGroupDTO getByName(String name) {
        ProductGroupEntity e = productGroupJpaRepository.findByGroupName(name)
                .orElseThrow(() -> new CustomExceptionHandler("ProductGroup with name " + name + " not found",
                        EnumCode.BAD_REQUEST));
        return ProductGroupMapper.INSTANCE.toDTO(e);
    }

    @Override
    public Page<ProductGroupDTO> getAll(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        return productGroupJpaRepository.findAll(pageable).map(ProductGroupMapper.INSTANCE::toDTO);
    }

    @Override
    public ProductGroupDTO getById(Long id) {
        // Method to be implemented...
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public String create(ProductGroupEntity model) {
        model.validateGroupNameUnique(productGroupUseCase);
        // ตรวจสอบ Business Logic ใน Domain Layer
        ProductGroupEntity saveProductGroup = productGroupJpaRepository.save(model);
        List<ProductOptionEntity> productOptionEntity = model
                .getProductOptions()
                .stream()
                .map((e) -> new ProductOptionEntity(e.getOptionName(), e.getPrice(), saveProductGroup))
                .toList();
        productOptionService.createAll(productOptionEntity);
        return "ProductOptionGroup has created";
    }

    @Override
    public void createAll(List<ProductGroupEntity> models) {
        // Method to be implemented...
        throw new UnsupportedOperationException("Unimplemented method 'createAll'");
    }

    @Override
    public void update(Long id, ProductGroupEntity model) {
        // Method to be implemented...
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // Method to be implemented...
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
