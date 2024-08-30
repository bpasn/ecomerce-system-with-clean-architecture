package com.app.infrastructure.repositories;

import com.app.domain.entity.CategoriesEntity;
import com.app.domain.repositories.ICategoriesRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesJpaRepository extends JpaRepository<CategoriesEntity,Long> , ICategoriesRepository {
    boolean existsByName(String name);
}
