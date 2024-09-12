package com.app.infrastructure.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.app.domain.entity.UserEntity;
import com.app.infrastructure.adapter.UserDetailsAdapter;
import com.app.infrastructure.exception.NotFoundException;
import com.app.infrastructure.repositories.UserJpaRepository;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetail implements UserDetailsService {
    private final UserJpaRepository userJpaRepository;

    public CustomUserDetail(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, NotFoundException {
        UserEntity user = userJpaRepository.findByEmail(username)
                .orElseThrow(() -> new NotFoundException("User", username));
        return new UserDetailsAdapter(user);
    }

}
