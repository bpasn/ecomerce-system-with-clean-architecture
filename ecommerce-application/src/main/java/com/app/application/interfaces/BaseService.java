package com.app.application.interfaces;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;

import com.app.application.ApiResponse;

public interface BaseService<E,D> {
    ApiResponse<Page<D>> getAllWithPage(int page,int size);
    ApiResponse<List<D>> getAll();
    ApiResponse<D> getById(UUID id);
    ApiResponse<D> create(D model);
    ApiResponse<List<D>> createAll(List<D> models);
    void update(UUID id,D model);
    void delete(UUID id);
}