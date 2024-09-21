package com.app.domain.usecase;

import java.util.List;

import com.app.domain.models.Store;

public interface StoreUseCase extends BaseUseCase<Store> {
    Store findFirstByOrderByIdDesc();
    Store findFirstByUserEmailOrderByIdDesc(String email);
    List<Store> findAllByUserEmail(String email);
    Store findByUserEmailAndId(String email,String id);
}
