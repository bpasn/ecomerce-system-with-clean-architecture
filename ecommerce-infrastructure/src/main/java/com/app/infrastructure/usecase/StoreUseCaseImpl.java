package com.app.infrastructure.usecase;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.app.domain.models.Store;
import com.app.domain.usecase.StoreUseCase;
import com.app.infrastructure.entity.StoreEntity;
import com.app.infrastructure.mapper.StoreMapperInfra;
import com.app.infrastructure.repositories.StoreJpaRepository;

@Service
public class StoreUseCaseImpl extends BaseUseCaseImpl<StoreEntity, Store> implements StoreUseCase {
    private static final Logger log = LoggerFactory.getLogger(StoreUseCaseImpl.class);
    private final StoreJpaRepository storeJpaRepository;
    private final StoreMapperInfra storeMapper;

    public StoreUseCaseImpl(StoreJpaRepository storeJpaRepository, StoreMapperInfra storeMapper) {
        super(storeJpaRepository, storeMapper);
        this.storeJpaRepository = storeJpaRepository;
        this.storeMapper = storeMapper;
    }

    @Override
    public Optional<Store> findFirstByOrderByIdDesc() {
        return storeJpaRepository.findFirstByOrderByIdDesc().map(storeMapper::toModel);
    }

    @Override
    public Store findFirstByUserEmailOrderByIdDesc(String email) {
        StoreEntity storeEntity = storeJpaRepository.findFirstByUserEmailOrderByIdDesc(email).orElse(null);
        if(storeEntity != null){
            Store store = storeMapper.toModel(storeEntity);
            return store;
        }
        return null;
    }

    @Override
    public List<Store> findAllByUserEmail(String email) {
        return storeJpaRepository.findAllByUserEmail(email).stream().map(storeMapper::toModel).toList();
    }

    @Override
    public Optional<Store> findByUserEmailAndId(String email, String id) {
        return storeJpaRepository.findByUserEmailAndId(email, id).map(storeMapper::toModel);
    }

}
