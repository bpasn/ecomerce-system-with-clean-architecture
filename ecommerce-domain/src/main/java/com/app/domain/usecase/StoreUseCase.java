package com.app.domain.usecase;

import com.app.domain.entity.StoreEntity;
import java.util.List;

public interface StoreUseCase extends BaseUseCase<StoreEntity> {
    StoreEntity findFirstByOrderByIdDesc();
    StoreEntity findFirstByUserEmailOrderByIdDesc(String email);
    List<StoreEntity> findAllByUserEmail(String email);
    StoreEntity findByUserEmailAndId(String email,String id);
}
