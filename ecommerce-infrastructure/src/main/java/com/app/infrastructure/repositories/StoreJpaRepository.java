package com.app.infrastructure.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.app.domain.entity.StoreEntity;
import com.app.domain.repositories.IStoreRepository;

public interface StoreJpaRepository extends JpaRepository<StoreEntity,String>,IStoreRepository {

}
