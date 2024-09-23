package com.app.application.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.StoreDTO;
import com.app.application.interfaces.StoreService;
import com.app.application.mapper.StoreMapper;
import com.app.domain.models.Store;
import com.app.domain.usecase.AuthUseCase;
import com.app.domain.usecase.StoreUseCase;

import jakarta.transaction.Transactional;

@Service
public class StoreServiceImpl extends BaseServiceImpl<Store, StoreDTO> implements StoreService {

    private final StoreUseCase storeUseCase;
    private final AuthUseCase authUseCase;
    private final StoreMapper storeMapper;

    public StoreServiceImpl(StoreUseCase storeUseCase, StoreMapper storeMapper, AuthUseCase authUseCase) {
        super(storeUseCase, storeMapper, Store.class);
        this.storeUseCase = storeUseCase;
        this.authUseCase = authUseCase;
        this.storeMapper = storeMapper;
    }

    @Override
    @Transactional
    public ApiResponse<StoreDTO> create(StoreDTO storeDTO) {
        UserDetails userDetails = getUserDetails();
        Store store = new Store();
        store.setStoreName(storeDTO.getStoreName());
        store.setUser(authUseCase.findByEmail(userDetails.getUsername()));

        Store saveStore =  storeUseCase.save(store);

        return new ApiResponse<>(storeMapper.toDTO(saveStore));
    }

    @Override
    public ApiResponse<StoreDTO> findFirstByUserEmailOrderByIdDesc() {
        Store store = storeUseCase.findFirstByUserEmailOrderByIdDesc("admin@admin.com");
        StoreDTO storeDto = storeMapper.toDTO(store);
        return new ApiResponse<>(storeDto);
    }

    @Override
    public ApiResponse<List<StoreDTO>> findAllByUserEmail() {
        UserDetails u = getUserDetails();
        return new ApiResponse<>(
                storeUseCase.findAllByUserEmail(u.getUsername()).stream().map(StoreMapper.INSTANCE::toDTO).toList());
    }

    @Override
    public ApiResponse<StoreDTO> getByUserEmailAndId(String id) {
        UserDetails u = getUserDetails();
        Store store = storeUseCase.findByUserEmailAndId(u.getUsername(), id).orElse(null);
        return new ApiResponse<>(StoreMapper.INSTANCE.toDTO(store));
    }

}
