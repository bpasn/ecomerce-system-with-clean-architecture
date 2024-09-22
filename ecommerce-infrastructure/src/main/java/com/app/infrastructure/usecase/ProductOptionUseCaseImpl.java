package com.app.infrastructure.usecase;

import org.springframework.stereotype.Service;
import java.util.List;
import com.app.domain.models.ProductOption;
import com.app.domain.usecase.ProductOptionUseCase;
import com.app.infrastructure.entity.ProductOptionEntity;
import com.app.infrastructure.mapper.ProductOptionMapperInfra;
import com.app.infrastructure.repositories.ProductOptionJpaRepository;

@Service
public class ProductOptionUseCaseImpl extends BaseUseCaseImpl<ProductOptionEntity,ProductOption> implements ProductOptionUseCase {

    private final ProductOptionJpaRepository productOptionJpaRepository;
    private final ProductOptionMapperInfra productOptionMapper;

    public ProductOptionUseCaseImpl(ProductOptionJpaRepository productOptionJpaRepository,ProductOptionMapperInfra productOptionMapper) {
        super(productOptionJpaRepository,productOptionMapper);
        this.productOptionJpaRepository = productOptionJpaRepository;
        this.productOptionMapper = productOptionMapper;
    }

    @Override
    public ProductOption getByOptionName(String optionName) {
       return productOptionMapper.toModel(productOptionJpaRepository.findByOptionName(optionName));
    }

    @Override
    public List<ProductOption> findAllByStoreId(String storeId) {
        return productOptionJpaRepository.findAllByStoreId(storeId).stream().map(productOptionMapper::toModel).toList();
    }
    
}
