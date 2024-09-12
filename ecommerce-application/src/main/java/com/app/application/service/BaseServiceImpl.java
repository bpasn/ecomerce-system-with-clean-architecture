package com.app.application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.app.application.dto.ApiResponse;
import com.app.application.interfaces.BaseService;
import com.app.application.mapper.BaseMapper;
import com.app.domain.usecase.BaseUseCase;
import com.app.infrastructure.exception.NotFoundException;

public class BaseServiceImpl<E, D> implements BaseService<E, D> {
    private final BaseUseCase<E> baseUseCase;
    private final BaseMapper<D, E> baseMapper;
    private final Class<E> clazz;

    public BaseServiceImpl(BaseUseCase<E> baseUseCase, BaseMapper<D, E> baseMapper,Class<E> clazz) {
        this.baseUseCase = baseUseCase;
        this.baseMapper = baseMapper;
        this.clazz = clazz;

    }

    @Override
    public ApiResponse<Page<D>> getAllWithPage(int page, int size) {
        try {
            Page<E> cPage = baseUseCase.findAllWithPageable(size, page);
            return new ApiResponse<>(cPage.map(baseMapper::toDTO));
        } catch (Exception e) {
            // Logging error or additional handling
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to retrieve paginated data", e);
        }
    }

    @Override
    public ApiResponse<List<D>> getAll() {
        try {
            List<E> entities = baseUseCase.findAll();
            return new ApiResponse<>(entities.stream()
                    .map(baseMapper::toDTO)
                    .collect(Collectors.toList()));
        } catch (Exception e) {
            // Logging error or additional handling
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to retrieve data", e);
        }
    }

    @Override
    public ApiResponse<D> getById(String id) {
        try {
            E entity = baseUseCase.findById(id)
                    .orElseThrow(() -> new NotFoundException(clazz.getSimpleName(), id));
            ApiResponse<D> response = new ApiResponse<>(baseMapper.toDTO(entity), HttpStatus.OK);
            System.out.println(response.toString());
            return response;
        } catch (Exception e) {
            // Logging error or additional handling
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to retrieve entity by ID", e);
        }
    }

    @Override
    public ApiResponse<D> create(D model) {
        try {
            E entity = baseMapper.toEntity(model);
            E savedEntity = baseUseCase.insert(entity);
            return new ApiResponse<>(baseMapper.toDTO(savedEntity));
        } catch (Exception e) {
            // Logging error or additional handling
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to create entity", e);
        }
    }

    @Override
    public ApiResponse<List<D>> createAll(List<D> models) {
        try {
            List<E> entities = models.stream()
                    .map(baseMapper::toEntity)
                    .collect(Collectors.toList());
            return new ApiResponse<>(baseUseCase.insertAll(entities).stream().map(baseMapper::toDTO).toList());
        } catch (Exception e) {
            // Logging error or additional handling
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to create entities", e);
        }
    }

    @Override
    public void update(String id, D model) {
        try {
            if (!baseUseCase.findById(id).isPresent()) {
                throw new NotFoundException(clazz.getSimpleName(), id);
            }
            E entity = baseMapper.toEntity(model);
            baseUseCase.update(id, entity);
        } catch (NotFoundException e) {
            throw e; // Re-throwing to maintain specific HTTP status
        } catch (Exception e) {
            // Logging error or additional handling
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to update entity", e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            if (!baseUseCase.findById(id).isPresent()) {
                throw new NotFoundException(clazz.getSimpleName(), id);
            }
            baseUseCase.delete(id);
        } catch (NotFoundException e) {
            throw e; // Re-throwing to maintain specific HTTP status
        } catch (Exception e) {
            // Logging error or additional handling
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to delete entity", e);
        }
    }

}
