package com.app.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.app.application.dto.CategoriesDTO;
import com.app.application.interfaces.CategoryService;
import com.app.application.mapper.CategoryMapper;
import com.app.domain.entity.CategoriesEntity;
import com.app.domain.exceptions.CustomExceptionHandler;
import com.app.domain.exceptions.EnumCode;
import com.app.domain.usecase.CategoryUseCase;

import jakarta.transaction.Transactional;

@Service
public class CategoriesServiceImpl implements CategoryService {

    private final CategoryUseCase categoryUseCase;

    CategoriesServiceImpl(CategoryUseCase categoryUseCase) {
        this.categoryUseCase = categoryUseCase;
    }

    @Override
    public Page<CategoriesDTO> getAll(int page, int size) {
        Page<CategoriesEntity> cPage = categoryUseCase.findAllWithPageable(size, page);
        System.out.println(cPage.toString());
        return cPage.map(CategoryMapper.INSTANCE::toDTO);
    }

    @Override
    public CategoriesDTO getById(Long id) {
        return CategoryMapper.INSTANCE.toDTO(categoryUseCase.findById(id).orElse(null));
    }

    @Override
    public String create(CategoriesDTO model) {
        CategoriesEntity entity = CategoryMapper.INSTANCE.toEntity(model);
        entity.validateCategoryNameExists(categoryUseCase);
        categoryUseCase.insert(entity);
        return "Category created";
    }

    @Override
    public void update(Long id, CategoriesDTO model) {
        Optional<CategoriesEntity> cateOptional = categoryUseCase.findById(id);
        if (cateOptional.isEmpty()) {
            throw new CustomExceptionHandler("Category with id " + id + " not found", EnumCode.NOT_FOUND);
        }
        CategoriesEntity cateEntity = cateOptional.get();
        cateEntity.setName(model.getName());
        categoryUseCase.insert(cateEntity);
    }

    @Override
    public void delete(Long id) {
        categoryUseCase.delete(id);
    }

    @Override
    @Transactional
    public void createAll(List<CategoriesDTO> models) {
        List<CategoriesEntity> entities = models.stream().map(CategoryMapper.INSTANCE::toEntity).toList();
        categoryUseCase.insertAll(entities);
    }

    @Override
    public CategoriesDTO getByName(String name) {
        return CategoryMapper.INSTANCE.toDTO(categoryUseCase.findByName(name));
    }
    
}
