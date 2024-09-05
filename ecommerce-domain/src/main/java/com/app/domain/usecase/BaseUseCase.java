package com.app.domain.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

public interface BaseUseCase<E> {
    E insert(E entity);
    E update(String id,E entity);
    List<E> insertAll(List<E> entity);
    Optional<E> findById(String id);
    Page<E> findAllWithPageable(int size,int page);
    List<E> findAll();
    List<E> findAllById(List<String> ids);
    void delete(String id);
    Class<E> getClazz();

}
