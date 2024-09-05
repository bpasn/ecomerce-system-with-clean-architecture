package com.app.infrastructure.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.domain.usecase.BaseUseCase;

public class BaseUseCaseImpl<E> implements BaseUseCase<E> {
    private final JpaRepository<E, String> repository;
    public BaseUseCaseImpl(JpaRepository<E,String> repository) {
        this.repository = repository;
    }

    @Override
    public E insert(E entity) {
        return repository.save(entity);
    }

    @Override
    public E update(String id, E entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public List<E> insertAll(List<E> entity) {
        return repository.saveAll(entity);
    }

    @Override
    public Optional<E> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Page<E> findAllWithPageable(int size, int page) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        return repository.findAll(pageable);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<E> findAllById(List<String> ids) {
        return repository.findAllById(ids);
    }

    @Override
    public Class<E> getClazz() {
        return null;
    }

}
