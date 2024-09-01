package com.app.application.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;

public interface BaseService<E,D> {
    Page<D> getAllWithPage(int page,int size);
    List<D> getAll();
    D getById(Long id);
    D create(D model);
    abstract void createAll(List<D> models);
    void update(Long id,D model);
    void delete(Long id);
}
