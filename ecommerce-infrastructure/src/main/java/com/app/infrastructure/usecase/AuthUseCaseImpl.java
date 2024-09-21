package com.app.infrastructure.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.app.domain.models.User;
import com.app.domain.usecase.AuthUseCase;
import com.app.infrastructure.entity.UserEntity;
import com.app.infrastructure.repositories.UserJpaRepository;

@Service
public class AuthUseCaseImpl extends BaseUseCaseImpl<UserEntity,User> implements AuthUseCase {

    private final UserJpaRepository userJpaRepository;
    public AuthUseCaseImpl(UserJpaRepository userJpaRepository) {
        super(userJpaRepository);
        this.userJpaRepository = userJpaRepository;
    }
    @Override
    public User findByEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByEmail'");
    }
    @Override
    public User save(User entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
    @Override
    public List<User> saveAll(List<User> entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }
    @Override
    public Optional<User> findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
    @Override
    public Page<User> findAllWithPageable(int size, int page) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllWithPageable'");
    }
    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    @Override
    public List<User> findAllById(List<String> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
    }
    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    @Override
    public Class<User> getClazz() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getClazz'");
    }

}
