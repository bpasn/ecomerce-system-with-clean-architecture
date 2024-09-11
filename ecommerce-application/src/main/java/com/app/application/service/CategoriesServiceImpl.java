package com.app.application.service;

import org.springframework.stereotype.Service;

import com.app.application.dto.CategoriesDTO;
import com.app.application.interfaces.CategoryService;
import com.app.application.mapper.CategoryMapper;
import com.app.domain.entity.ProductCategoriesEntity;
import com.app.domain.usecase.ProductCategoryUseCase;


@Service
public class CategoriesServiceImpl extends BaseServiceImpl<ProductCategoriesEntity, CategoriesDTO> implements CategoryService {


    CategoriesServiceImpl(ProductCategoryUseCase categoryUseCase, CategoryMapper categoryMapper) {
        super(categoryUseCase, categoryMapper,ProductCategoriesEntity.class);
    }

    @Override
    public CategoriesDTO getByName(String name) {
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }

}
