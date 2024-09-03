package com.app.application.service;

import org.springframework.stereotype.Service;

import com.app.application.dto.CategoriesDTO;
import com.app.application.interfaces.CategoryService;
import com.app.application.mapper.CategoryMapper;
import com.app.domain.entity.CategoriesEntity;
import com.app.domain.usecase.CategoryUseCase;


@Service
public class CategoriesServiceImpl extends BaseServiceImpl<CategoriesEntity, CategoriesDTO> implements CategoryService {

    private final CategoryUseCase categoryUseCase;
    private final CategoryMapper categoryMapper;

    CategoriesServiceImpl(CategoryUseCase categoryUseCase, CategoryMapper categoryMapper) {
        super(categoryUseCase, categoryMapper);
        this.categoryUseCase = categoryUseCase;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoriesDTO getByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }

}
