package com.app.infrastructure.usecase;


import org.springframework.stereotype.Service;

import com.app.domain.entity.ProductGroupEntity;
import com.app.domain.usecase.ProductGroupUseCase;
import com.app.infrastructure.repositories.ProductGroupJpaRepository;


@Service
public class ProductGroupUseCaseImpl extends BaseUseCaseImpl<ProductGroupEntity> implements ProductGroupUseCase {

   private final ProductGroupJpaRepository productGroupJpaRepository;

   public ProductGroupUseCaseImpl(ProductGroupJpaRepository productGroupJpaRepository) {
      super(productGroupJpaRepository);
      this.productGroupJpaRepository = productGroupJpaRepository;
   }

   @Override
   public boolean isGroupNameExists(String groupName) {
      return productGroupJpaRepository.findByGroupName(groupName).isPresent();
   }

   @Override
   public ProductGroupEntity getByGroupName(String groupName) {
      return productGroupJpaRepository.findByGroupName(groupName).orElse(null);
   }


}
