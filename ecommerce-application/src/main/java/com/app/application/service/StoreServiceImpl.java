package com.app.application.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.StoreDTO;
import com.app.application.interfaces.StoreService;
import com.app.application.mapper.StoreMapper;
import com.app.domain.entity.StoreEntity;
import com.app.domain.usecase.StoreUseCase;
import com.app.infrastructure.adapter.UserDetailsAdapter;

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

    @Override
    public ApiResponse<StoreDTO> create(StoreDTO storeDTO){
        return new ApiResponse<StoreDTO>(storeDTO);
    }

    

}
