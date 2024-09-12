package com.app.application.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.StoreDTO;
import com.app.application.interfaces.StoreService;
import com.app.application.mapper.StoreMapper;
import com.app.domain.entity.StoreEntity;
import com.app.domain.usecase.StoreUseCase;

@Service
public class StoreServiceImpl extends BaseServiceImpl<StoreEntity, StoreDTO> implements StoreService {

    private final StoreUseCase storeUseCase;

    public StoreServiceImpl(StoreUseCase storeUseCase, StoreMapper storeMapper) {
        super(storeUseCase, storeMapper,StoreEntity.class);
        this.storeUseCase = storeUseCase;
    }

    @Override
    public ApiResponse<StoreDTO> findFirstByOrderByIdDesc() {
        return new ApiResponse<>(StoreMapper.INSTANCE.toDTO(storeUseCase.findFirstByOrderByIdDesc()));
    }

    

}
