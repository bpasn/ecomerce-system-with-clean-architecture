package com.app.application.mapper;

public interface BaseMapper<D,E> {

    D toDTO(E e);
    E toEntity(D d);

}
