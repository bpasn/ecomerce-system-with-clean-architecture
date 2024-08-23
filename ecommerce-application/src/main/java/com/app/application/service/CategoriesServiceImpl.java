package com.app.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.application.dto.CategoriesDTO;
import com.app.application.handler.CustomExceptionHandler;
import com.app.application.handler.EnumCode;
import com.app.application.interfaces.CategoryService;
import com.app.application.mapper.CategoryMapper;
import com.app.domain.entity.CategoriesEntity;
import com.app.infrastructure.repositories.CategoriesJpaRepository;

import jakarta.transaction.Transactional;

@Service
public class CategoriesServiceImpl implements CategoryService {

    private final CategoriesJpaRepository repository;

    CategoriesServiceImpl(CategoriesJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<CategoriesDTO> getAll(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        return repository.findAll(pageable).map(CategoryMapper.INSTANCE::toDTO);
    }

    @Override
    public CategoriesDTO getById(Long id) {
        return repository.findById(id).map(CategoryMapper.INSTANCE::toDTO).orElse(null);
    }

    @Override
    public String create(CategoriesDTO model) {
        repository.save(CategoryMapper.INSTANCE.toEntity(model));
        return "Category created";
    }

    @Override
    public void update(Long id, CategoriesDTO model) {
        Optional<CategoriesEntity> cateOptional = repository.findById(id);
        if (cateOptional.isEmpty()) {
            throw new CustomExceptionHandler("Category with id " + id + " not found", EnumCode.NOT_FOUND);
        }
        CategoriesEntity cateEntity = cateOptional.get();
        cateEntity.setName(model.getName());
        repository.save(cateEntity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void createAll(List<CategoriesDTO> models) {
        repository.saveAll(models.stream().map(CategoryMapper.INSTANCE::toEntity).toList());
    }

    @Override
    public CategoriesDTO getByName(String name) {
        return repository.findByName(name).map(CategoryMapper.INSTANCE::toDTO).orElse(null);
    }
    
}
