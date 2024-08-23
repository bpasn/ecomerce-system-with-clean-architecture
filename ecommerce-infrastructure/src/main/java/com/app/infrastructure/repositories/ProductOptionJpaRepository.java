package com.app.infrastructure.repositories;

import com.app.domain.entity.ProductOptionEntity;
import com.app.domain.repositories.IProductOptionRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOptionJpaRepository extends JpaRepository<ProductOptionEntity,Long>, IProductOptionRepository {
}
