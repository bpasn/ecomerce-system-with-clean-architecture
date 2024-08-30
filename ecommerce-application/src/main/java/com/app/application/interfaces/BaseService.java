package com.app.application.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;

public interface BaseService<E,D> {
    Page<D> getAll(int page,int size);
    D getByName(String name);
    D getById(Long id);
    String create(D model);
    void createAll(List<D> models);
    void update(Long id,D model);
    void delete(Long id);
}
