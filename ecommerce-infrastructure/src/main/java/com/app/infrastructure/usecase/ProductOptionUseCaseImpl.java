package com.app.infrastructure.usecase;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.app.domain.models.ProductOption;
import com.app.domain.usecase.OptionChoiceUseCase;
import com.app.domain.usecase.ProductOptionUseCase;
import com.app.infrastructure.entity.ProductOptionEntity;
import com.app.infrastructure.exception.BaseException;
import com.app.infrastructure.mapper.ProductOptionMapperInfra;
import com.app.infrastructure.repositories.ProductOptionJpaRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductOptionUseCaseImpl extends BaseUseCaseImpl<ProductOptionEntity, ProductOption>
        implements ProductOptionUseCase {

    private final ProductOptionJpaRepository productOptionJpaRepository;
    private final OptionChoiceUseCase optionChoiceUseCase;
    private final ProductOptionMapperInfra productOptionMapper;

    public ProductOptionUseCaseImpl(ProductOptionJpaRepository productOptionJpaRepository,
            ProductOptionMapperInfra productOptionMapper, OptionChoiceUseCase optionChoiceUseCase) {
        super(productOptionJpaRepository, productOptionMapper);
        this.productOptionJpaRepository = productOptionJpaRepository;
        this.productOptionMapper = productOptionMapper;
        this.optionChoiceUseCase = optionChoiceUseCase;
    }

    @Override
    public ProductOption getByOptionName(String optionName) {
        return productOptionMapper.toModel(productOptionJpaRepository.findByOptionName(optionName));
    }

    @Override
    public List<ProductOption> findAllByStoreId(String storeId) {
        List<ProductOptionEntity> productOptionEntity = productOptionJpaRepository.findAllByStoreId(storeId);
        List<ProductOption> productOptions = productOptionEntity.stream().map(productOptionMapper::toModel)
                .collect(Collectors.toList());
        return new ArrayList<>(productOptions);
    }

    @Override
    @Transactional
    public void delete(String id) {
        ProductOptionEntity productOptionEntity = productOptionJpaRepository.findById(id).orElse(null);

        if (productOptionEntity == null) {
            throw new BaseException("Product option not found", HttpStatus.CONFLICT);
        }
        if (!productOptionEntity.getProducts().isEmpty()) {
            throw new BaseException("ProductOption is still referenced by products", HttpStatus.BAD_REQUEST);
        }

        optionChoiceUseCase.deleteAllByProductOptionId(id);
        productOptionJpaRepository.delete(productOptionEntity);
    }

}
