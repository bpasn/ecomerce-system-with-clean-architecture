package com.app.domain.repositories;

import java.util.Optional;

import com.app.domain.models.Store;

import java.util.List;

public interface IStoreRepository  {
    Optional<Store> findFirstByOrderByIdDesc();
    Optional<Store> findFirstByUserEmailOrderByIdDesc(String email);
    List<Store> findAllByUserEmail(String email);
    Store findByUserEmailAndId(String email,String id);
}
