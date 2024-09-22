package com.app.application.mapper;


public interface BaseMapper<D,M> {
    D toDTO(M e);
    M toModel(D d);

}
