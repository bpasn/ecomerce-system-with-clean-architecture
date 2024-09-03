package com.app.domain.repositories;

import java.util.Optional;

import com.app.domain.entity.StoreEntity;

public interface IStoreRepository  {
    Optional<StoreEntity> findFirstByOrderByIdDesc();
}
