package com.app.domain.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

public interface BaseUseCase<M> {
    M save(M entity);
    List<M> saveAll(List<M> entity);
    Optional<M> findById(String id);
    Page<M> findAllWithPageable(int size,int page);
    List<M> findAll();
    List<M> findAllById(List<String> ids);
    void delete(String id);
    Class<M> getClazz();

}
