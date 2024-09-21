package com.app.infrastructure.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.app.domain.repositories.IStoreRepository;
import com.app.infrastructure.entity.StoreEntity;

public interface StoreJpaRepository extends JpaRepository<StoreEntity,String>,IStoreRepository {

}
