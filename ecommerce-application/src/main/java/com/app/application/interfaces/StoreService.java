package com.app.application.interfaces;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.StoreDTO;
import com.app.domain.models.Store;

import java.util.List;

public interface StoreService extends BaseService<Store, StoreDTO> {
    ApiResponse<StoreDTO> findFirstByUserEmailOrderByIdDesc();
    ApiResponse<List<StoreDTO>> findAllByUserEmail();
    ApiResponse<StoreDTO> getByUserEmailAndId(String id);
}
