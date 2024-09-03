package com.app.domain.usecase;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;

public interface BaseUseCase<E> {
    E insert(E entity);
    E update(UUID id,E entity);
    List<E> insertAll(List<E> entity);
    Optional<E> findById(UUID id);
    Page<E> findAllWithPageable(int size,int page);
    List<E> findAll();
    void delete(UUID id);

}
