package com.app.domain.repositories;

import java.util.Optional;


import java.util.List;

import com.app.domain.entity.StoreEntity;

public interface IStoreRepository  {
    Optional<StoreEntity> findFirstByOrderByIdDesc();
    Optional<StoreEntity> findFirstByUserEmailOrderByIdDesc(String email);
    List<StoreEntity> findAllByUserEmail(String email);
    StoreEntity findByUserEmailAndId(String email,String id);
}
