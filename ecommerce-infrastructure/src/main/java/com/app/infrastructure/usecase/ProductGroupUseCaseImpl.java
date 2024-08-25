package com.app.infrastructure.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.domain.entity.ProductGroupEntity;
import com.app.domain.exceptions.CustomExceptionHandler;
import com.app.domain.exceptions.EnumCode;
import com.app.domain.usecase.ProductGroupUseCase;
import com.app.infrastructure.repositories.ProductGroupJpaRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductGroupUseCaseImpl implements ProductGroupUseCase {

    private final ProductGroupJpaRepository productGroupJpaRepository;

    public ProductGroupUseCaseImpl(ProductGroupJpaRepository productGroupJpaRepository) {
        this.productGroupJpaRepository = productGroupJpaRepository;
    }

    @Override
    public boolean isGroupNameExists(String groupName) {
       return  productGroupJpaRepository.findByGroupName(groupName).isPresent();
    }

    @Override
    @Transactional
    public ProductGroupEntity insert(ProductGroupEntity entity) {
        return productGroupJpaRepository.save(entity);
    }

    @Override
    @Transactional
    public ProductGroupEntity update(Long id,ProductGroupEntity entity) {
       ProductGroupEntity p = productGroupJpaRepository.findById(id).orElse(null);
       if(p == null){
        throw new CustomExceptionHandler("Product Group with "+ entity.getGroupName()+" not found",EnumCode.NOT_FOUND);
       }
       p.setGroupName(entity.getGroupName());
       return productGroupJpaRepository.save(p);
    }

    @Override
    @Transactional
    public void delete(Long id) {
       productGroupJpaRepository.deleteById(id);
    }

    @Override
    public List<ProductGroupEntity> insertAll(List<ProductGroupEntity> entity) {
       return productGroupJpaRepository.saveAll(entity);
    }

   @Override
   public Optional<ProductGroupEntity> findById(Long id) {
     return productGroupJpaRepository.findById(id);
   }

   @Override
   public Page<ProductGroupEntity> findAllWithPageable(int size, int page) {
     return productGroupJpaRepository.findAll(Pageable.ofSize(size).withPage(page));
   }

}
