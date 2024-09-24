package com.app.infrastructure.usecase;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.domain.pageable.PageResult;
import com.app.domain.usecase.BaseUseCase;
import com.app.infrastructure.entity.ProductEntity;
import com.app.infrastructure.mapper.GenericMapper;

public class BaseUseCaseImpl<E, M> implements BaseUseCase<M> {
    private final JpaRepository<E, String> repository;
    private final GenericMapper<E, M> mapper;

    public BaseUseCaseImpl(JpaRepository<E, String> repository, GenericMapper<E, M> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public M save(M model) {
        E toEntity = mapper.toEntity(model);
        System.out.println(toEntity);
        E save = repository.save(toEntity);
        return mapper.toModel(save);
    }

    @Override
    public List<M> saveAll(List<M> model) {
        return repository.saveAll(model.stream().map(mapper::toEntity).toList()).stream().map(mapper::toModel).toList();

    }

    @Override
    public Optional<M> findById(String id) {
        E entity = repository.findById(id).orElse(null);
        if(entity instanceof ProductEntity){
            System.out.println(((ProductEntity) entity).getStock());
        }
        return repository.findById(id).map(mapper::toModel);
    }

    @Override
    public PageResult<M> findAllWithPageable(int size, int page) {
        Page<E> pageResult = repository.findAll(Pageable.ofSize(page).withPage(page));
        List<M> content = pageResult.getContent().stream().map(mapper::toModel).collect(Collectors.toList());
        return new PageResult<>(
                content,
                pageResult.getNumber(),
                pageResult.getSize(),
                pageResult.getTotalElements(),
                pageResult.getTotalPages());
    }

    @Override
    public List<M> findAll() {
        return repository.findAll().stream().map(mapper::toModel).toList();
    }

    @Override
    public List<M> findAllById(List<String> ids) {
        return repository.findAllById(ids).stream().map(mapper::toModel).toList();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
