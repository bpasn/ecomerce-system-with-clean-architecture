package com.app.infrastructure.usecase;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.app.domain.entity.StoreEntity;
import com.app.domain.usecase.StoreUseCase;
import com.app.infrastructure.repositories.StoreJpaRepository;


@Service
public class StoreUseCaseImpl extends BaseUseCaseImpl<StoreEntity> implements StoreUseCase{
    private final StoreJpaRepository storeJpaRepository;
    public StoreUseCaseImpl(StoreJpaRepository storeJpaRepository) {
        super(storeJpaRepository);
        this.storeJpaRepository = storeJpaRepository;
    }

    @Override
    public StoreEntity findFirstByOrderByIdDesc() {
        return storeJpaRepository.findFirstByOrderByIdDesc().orElse(null);
    }
    
}
