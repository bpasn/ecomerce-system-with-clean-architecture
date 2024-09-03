package com.app.infrastructure.repositories;

import com.app.domain.entity.CategoriesEntity;
import com.app.domain.repositories.ICategoriesRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesJpaRepository extends JpaRepository<CategoriesEntity,UUID> , ICategoriesRepository {
    boolean existsByName(String name);
}
