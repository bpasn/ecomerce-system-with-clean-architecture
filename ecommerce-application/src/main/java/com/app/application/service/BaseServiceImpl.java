package com.app.application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.server.ResponseStatusException;

import com.app.application.dto.ApiResponse;
import com.app.application.interfaces.BaseService;
import com.app.application.mapper.BaseMapper;
import com.app.domain.usecase.BaseUseCase;
import com.app.infrastructure.exception.BaseException;
import com.app.infrastructure.exception.NotFoundException;

public class BaseServiceImpl<M, D> implements BaseService<M, D> {
    private final BaseUseCase<M> baseUseCase;
    private final BaseMapper<D, M> baseMapper;
    private final Class<M> clazz;

    public BaseServiceImpl(BaseUseCase<M> baseUseCase, BaseMapper<D, M> baseMapper, Class<M> clazz) {
        this.baseUseCase = baseUseCase;
        this.baseMapper = baseMapper;
        this.clazz = clazz;

    }

    @Override
    public ApiResponse<Page<D>> getAllWithPage(int page, int size) {
        try {
            Page<M> cPage = baseUseCase.findAllWithPageable(size, page);
            return new ApiResponse<>(cPage.map(baseMapper::toDTO));
        } catch (Exception e) {
            // Logging error or additional handling
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to retrieve paginated data", e);
        }
    }

    @Override
    public ApiResponse<List<D>> getAll() {
        try {
            List<M> entities = baseUseCase.findAll();
            return new ApiResponse<>(entities.stream()
                    .map(baseMapper::toDTO)
                    .collect(Collectors.toList()));
        } catch (Exception e) {
            // Logging error or additional handling
            throw new BaseException("Failed to retrieve data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ApiResponse<D> getById(String id) {
        try {
            M entity = baseUseCase.findById(id).orElse(null);
            ApiResponse<D> response = new ApiResponse<>(baseMapper.toDTO(entity), HttpStatus.OK);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(String.format("Failed to retrieve %s with ID is %s", clazz.getSimpleName(), id),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ApiResponse<D> create(D model) {
        try {
            M entity = baseMapper.toEntity(model);
            M savedEntity = baseUseCase.save(entity);
            return new ApiResponse<>(baseMapper.toDTO(savedEntity));
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException("Failed to create " + clazz.getSimpleName(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ApiResponse<List<D>> createAll(List<D> models) {
        try {
            List<M> entities = models.stream()
                    .map(baseMapper::toEntity)
                    .collect(Collectors.toList());
            return new ApiResponse<>(baseUseCase.saveAll(entities).stream().map(baseMapper::toDTO).toList());
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to create entities", e);
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
            e.printStackTrace();
            throw new BaseException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); // Re-throwing to maintain
                                                                                       // specific HTTP status
        }
    }

    @Override
    public UserDetails getUserDetails() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        if (principal instanceof UserDetails) {
            return (UserDetails) principal;
        }
        return null;
    }

}
