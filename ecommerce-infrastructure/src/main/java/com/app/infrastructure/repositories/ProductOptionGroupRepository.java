package com.app.infrastructure.repositories;

import com.app.domain.entity.ProductOptionGroupEntity;
import com.app.domain.repositories.IProductOptionGroupRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOptionGroupRepository extends JpaRepository<ProductOptionGroupEntity,Long>, IProductOptionGroupRepository {
}
