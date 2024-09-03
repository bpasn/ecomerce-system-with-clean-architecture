package com.app.domain.usecase;

import com.app.domain.entity.StoreEntity;

public interface StoreUseCase extends BaseUseCase<StoreEntity> {
    StoreEntity findFirstByOrderByIdDesc();
}
