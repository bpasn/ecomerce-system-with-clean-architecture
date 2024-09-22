package com.app.infrastructure.mapper;

public interface GenericMapper<E,M> {
    E toEntity(M model);
    M toModel(E entity);
}
