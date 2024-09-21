package com.app.infrastructure.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.domain.usecase.BaseUseCase;

public class BaseUseCaseImpl<E, M> implements BaseUseCase<M> {
    private final JpaRepository<E, String> repository;

    public BaseUseCaseImpl(JpaRepository<E,String> repository) {
        this.repository = repository;
    }

    @Override
    public M save(M entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List<M> saveAll(List<M> entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }

    @Override
    public Optional<M> findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Page<M> findAllWithPageable(int size, int page) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllWithPageable'");
    }

    @Override
    public List<M> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public List<M> findAllById(List<String> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Class<M> getClazz() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getClazz'");
    }

}
