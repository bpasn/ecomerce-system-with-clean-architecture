package com.app.domain.repositories;

import java.util.Optional;

import com.app.domain.entity.CategoriesEntity;

public interface ICategoriesRepository {
    Optional<CategoriesEntity> findByName(String name);
}
