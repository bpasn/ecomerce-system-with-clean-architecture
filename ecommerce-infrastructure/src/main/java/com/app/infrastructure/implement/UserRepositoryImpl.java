
package com.app.infrastructure.implement;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.domain.entity.UserEntity;
import com.app.domain.repositories.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserEntity findCustom(String username, String email) {
        String queryString = "SELECT u FROM users u WHERE u.username = :username AND u.email = :email";
        TypedQuery<UserEntity> query = entityManager.createQuery(queryString, UserEntity.class);
        query.setParameter("username", username);
        query.setParameter("email", email);
        return query.getSingleResult();
    }

}
