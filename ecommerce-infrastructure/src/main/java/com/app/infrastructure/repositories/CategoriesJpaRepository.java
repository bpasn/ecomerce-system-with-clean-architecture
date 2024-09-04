package com.app.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.domain.entity.CategoriesEntity;
import com.app.domain.repositories.ICategoriesRepository;

public interface CategoriesJpaRepository extends JpaRepository<CategoriesEntity,String> , ICategoriesRepository {
    boolean existsByName(String name);
}
