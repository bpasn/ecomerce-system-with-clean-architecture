package com.app.domain.usecase;

import com.app.domain.models.User;

public interface AuthUseCase extends BaseUseCase<User> {
    User findByEmail(String email);
    User findByProviderAndProviderId(String provider,String providerId);
}
