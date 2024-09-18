package com.app.application.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.StoreDTO;
import com.app.application.interfaces.StoreService;
import com.app.application.mapper.StoreMapper;
import com.app.domain.entity.StoreEntity;
import com.app.domain.usecase.AuthUseCase;
import com.app.domain.usecase.StoreUseCase;

@Service
public class StoreServiceImpl extends BaseServiceImpl<StoreEntity, StoreDTO> implements StoreService {

    private final StoreUseCase storeUseCase;
    private final AuthUseCase authUseCase;

    public StoreServiceImpl(StoreUseCase storeUseCase, StoreMapper storeMapper, AuthUseCase authUseCase) {
        super(storeUseCase, storeMapper, StoreEntity.class);
        this.storeUseCase = storeUseCase;
        this.authUseCase = authUseCase;
    }

    @Override
    public ApiResponse<StoreDTO> create(StoreDTO storeDTO) {
        UserDetails userDetails = getUserDetails();
        StoreEntity storeEntity = new StoreEntity();
        storeEntity.setStoreName(storeDTO.getStoreName());
        storeEntity.setUser(authUseCase.findByEmail(userDetails.getUsername()));
        return new ApiResponse<>(StoreMapper.INSTANCE.toDTO(storeUseCase.save(storeEntity)));
    }

    @Override
    public ApiResponse<StoreDTO> findFirstByUserEmailOrderByIdDesc() {
        UserDetails u = getUserDetails();
        return new ApiResponse<>(StoreMapper.INSTANCE.toDTO(storeUseCase.findFirstByUserEmailOrderByIdDesc(u.getUsername())));
    }

    @Override
    public ApiResponse<List<StoreDTO>> findAllByUserEmail() {
        UserDetails u = getUserDetails();
        return new ApiResponse<>(storeUseCase.findAllByUserEmail(u.getUsername()).stream().map(StoreMapper.INSTANCE::toDTO).toList());
    }

    @Override
    public ApiResponse<StoreDTO> getByUserEmailAndId(String id) {
        UserDetails u = getUserDetails();
        return new ApiResponse<>(StoreMapper.INSTANCE.toDTO(storeUseCase.findByUserEmailAndId(u.getUsername(), id)));
    }

    

}
