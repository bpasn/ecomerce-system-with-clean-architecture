package com.app.application.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.domain.entity.BaseEntity;
public class BaseService<M extends BaseEntity> {
    private final JpaRepository<M, Long> repository;

    public BaseService(JpaRepository<M, Long> repository) {
        this.repository = repository;
    }

    public M create(M model){
        return repository.save(model);
    }

    public M getById(Long id){
        return repository.findById(id).orElse(null);
    }

    public M update(Long id,M model){
        model.setId(id);
        return repository.save(model);
    }
    
}
