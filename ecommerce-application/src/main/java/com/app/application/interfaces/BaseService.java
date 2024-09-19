package com.app.application.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.application.dto.ApiResponse;

public interface BaseService<E, D> {
    ApiResponse<Page<D>> getAllWithPage(int page, int size);

    ApiResponse<List<D>> getAll();

    ApiResponse<D> getById(String id);

    ApiResponse<D> create(D model);

    ApiResponse<List<D>> createAll(List<D> models);

    void delete(String id);

    UserDetails getUserDetails();
}
