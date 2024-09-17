package com.app.application.interfaces;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.StoreDTO;
import com.app.domain.entity.StoreEntity;
import java.util.List;

public interface StoreService extends BaseService<StoreEntity, StoreDTO> {
    ApiResponse<StoreDTO> findFirstByUserEmailOrderByIdDesc();
    ApiResponse<List<StoreDTO>> findAllByUserEmail();
    ApiResponse<StoreDTO> getByUserEmailAndId(String id);
}
