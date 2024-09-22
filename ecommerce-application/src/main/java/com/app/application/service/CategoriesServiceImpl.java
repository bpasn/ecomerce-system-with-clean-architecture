package com.app.application.service;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.StoreDTO;
import com.app.application.mapper.StoreMapper;
import com.app.domain.usecase.StoreUseCase;
import com.app.infrastructure.exception.BaseException;
import com.app.infrastructure.exception.NotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.app.application.dto.CategoriesDTO;
import com.app.application.interfaces.CategoryService;
import com.app.application.mapper.CategoryMapper;
import com.app.domain.models.ProductCategories;
import com.app.domain.models.Store;
import com.app.domain.usecase.ProductCategoryUseCase;

import java.util.List;


@Service
public class CategoriesServiceImpl extends BaseServiceImpl<ProductCategories, CategoriesDTO> implements CategoryService {

    private final ProductCategoryUseCase productCategoryUseCase;
    private final StoreUseCase storeUseCase;
    private final CategoryMapper categoryMapper;
    CategoriesServiceImpl(ProductCategoryUseCase productCategoryUseCase, CategoryMapper categoryMapper,StoreUseCase storeUseCase) {
        super(productCategoryUseCase, categoryMapper,ProductCategories.class);
        this.productCategoryUseCase = productCategoryUseCase;
        this.storeUseCase = storeUseCase;
        this.categoryMapper = categoryMapper;

    }

    @Override
    public CategoriesDTO getByName(String name) {
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }

    @Override
    public ApiResponse<List<CategoriesDTO>> getAllByStoreId(String storeId) {
        List<CategoriesDTO> categoriesDTOS = productCategoryUseCase.findAllByStoreId(storeId).stream().map(categoryMapper::toDTO).toList();
        return new ApiResponse<>(categoriesDTOS);
    }

    @Override
    public ApiResponse<CategoriesDTO> create(CategoriesDTO dto){
        ProductCategories p = categoryMapper.toModel(dto);
        Store storeEntity = storeUseCase.findById(dto.getStoreId()).orElseThrow(() -> new NotFoundException("Store", dto.getStoreId()));
        p.setStore(storeEntity);
        return new ApiResponse<>(categoryMapper.toDTO(productCategoryUseCase.save(p)));
    }
}
