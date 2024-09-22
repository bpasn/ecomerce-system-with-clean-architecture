package com.app.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.infrastructure.entity.StoreEntity;

public interface StoreJpaRepository extends JpaRepository<StoreEntity, String> {
    Optional<StoreEntity> findFirstByOrderByIdDesc();

    Optional<StoreEntity> findFirstByUserEmailOrderByIdDesc(String email);

    List<StoreEntity> findAllByUserEmail(String email);

    Optional<StoreEntity> findByUserEmailAndId(String email, String id);
}
