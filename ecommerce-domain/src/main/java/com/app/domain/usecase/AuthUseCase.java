package com.app.domain.usecase;

import com.app.domain.entity.UserEntity;

public interface AuthUseCase extends  BaseUseCase<UserEntity> {
    UserEntity findByEmail(String email);
}
