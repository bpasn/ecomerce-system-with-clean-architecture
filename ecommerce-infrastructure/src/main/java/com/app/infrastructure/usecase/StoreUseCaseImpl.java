package com.app.infrastructure.usecase;


import java.util.List;

import org.springframework.stereotype.Service;

import com.app.domain.models.Store;
import com.app.domain.usecase.StoreUseCase;
import com.app.infrastructure.entity.StoreEntity;
import com.app.infrastructure.repositories.StoreJpaRepository;


@Service
public class StoreUseCaseImpl extends BaseUseCaseImpl<StoreEntity,Store> implements StoreUseCase{
    private final StoreJpaRepository storeJpaRepository;
    public StoreUseCaseImpl(StoreJpaRepository storeJpaRepository) {
        super(storeJpaRepository);
        this.storeJpaRepository = storeJpaRepository;
    }

    @Override
    public Store findFirstByOrderByIdDesc() {
        return storeJpaRepository.findFirstByOrderByIdDesc().orElse(null);
    }

    @Override
    public Store findFirstByUserEmailOrderByIdDesc(String email) {
        return storeJpaRepository.findFirstByUserEmailOrderByIdDesc(email).orElse(null);
    }

    @Override
    public List<Store> findAllByUserEmail(String email) {
        return storeJpaRepository.findAllByUserEmail(email);
    }

    @Override
    public Store findByUserEmailAndId(String email, String id) {
        return storeJpaRepository.findByUserEmailAndId(email, id);
    }

    

    
}
