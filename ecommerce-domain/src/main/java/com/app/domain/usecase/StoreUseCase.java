package com.app.domain.usecase;

import java.util.List;
import java.util.Optional;

import com.app.domain.models.Store;

public interface StoreUseCase extends BaseUseCase<Store> {
    Optional<Store> findFirstByOrderByIdDesc();
    Optional<Store> findFirstByUserEmailOrderByIdDesc(String email);
    List<Store> findAllByUserEmail(String email);
    Optional<Store> findByUserEmailAndId(String email,String id);
}
