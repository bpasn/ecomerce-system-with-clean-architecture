package com.app.application.interfaces;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.StoreDTO;
import com.app.domain.entity.StoreEntity;


public interface StoreService extends BaseService<StoreEntity, StoreDTO> {
    ApiResponse<StoreDTO> findFirstByOrderByIdDesc();
}
