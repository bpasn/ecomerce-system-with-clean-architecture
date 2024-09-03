package com.app.application.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.web.server.ResponseStatusException;

import com.app.application.ApiResponse;
import com.app.application.interfaces.BaseService;
import com.app.application.mapper.BaseMapper;
import com.app.domain.usecase.BaseUseCase;

import org.springframework.http.HttpStatus;

public class BaseServiceImpl<E, D> implements BaseService<E, D> {
    private final BaseUseCase<E> baseUseCase;
    private final BaseMapper<D, E> baseMapper;

    public BaseServiceImpl(BaseUseCase<E> baseUseCase, BaseMapper<D, E> baseMapper) {
        this.baseUseCase = baseUseCase;
        this.baseMapper = baseMapper;
    }

    @Override
    public ApiResponse<Page<D>> getAllWithPage(int page, int size) {
        try {
            Page<E> cPage = baseUseCase.findAllWithPageable(size, page);
            ApiResponse<Page<D>> response = new ApiResponse<>();
            response.setPayload(cPage.map(baseMapper::toDTO));
            return response;
        } catch (Exception e) {
            // Logging error or additional handling
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to retrieve paginated data", e);
        }
    }

    @Override
    public ApiResponse<List<D>> getAll() {
        try {
            List<E> entities = baseUseCase.findAll();
            ApiResponse<List<D>> response = new ApiResponse<>();
            response.setPayload(entities.stream()
                    .map(baseMapper::toDTO)
                    .collect(Collectors.toList()));
            return response;
        } catch (Exception e) {
            // Logging error or additional handling
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to retrieve data", e);
        }
    }

    @Override
    public ApiResponse<D> getById(UUID id) {
        try {
            Optional<E> entity = baseUseCase.findById(id);
            return new ApiResponse<>(entity.map(baseMapper::toDTO).orElse(null));
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
    public void update(UUID id, D model) {
        try {
            if (!baseUseCase.findById(id).isPresent()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found with ID: " + id);
            }
            E entity = baseMapper.toEntity(model);
            baseUseCase.update(id, entity);
        } catch (ResponseStatusException e) {
            throw e; // Re-throwing to maintain specific HTTP status
        } catch (Exception e) {
            // Logging error or additional handling
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to update entity", e);
        }
    }

    @Override
    public void delete(UUID id) {
        try {
            if (!baseUseCase.findById(id).isPresent()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found with ID: " + id);
            }
            baseUseCase.delete(id);
        } catch (ResponseStatusException e) {
            throw e; // Re-throwing to maintain specific HTTP status
        } catch (Exception e) {
            // Logging error or additional handling
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to delete entity", e);
        }
    }
}
