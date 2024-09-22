package com.app.domain.usecase;

import java.util.List;
import java.util.Optional;

import com.app.domain.pageable.PageResult;


public interface BaseUseCase<M> {
    M save(M model);
    List<M> saveAll(List<M> model);
    Optional<M> findById(String id);
    PageResult<M> findAllWithPageable(int size,int page);
    List<M> findAll();
    List<M> findAllById(List<String> ids);
    void delete(String id);

}
