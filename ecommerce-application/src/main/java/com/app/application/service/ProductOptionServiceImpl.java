package com.app.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.ProductOptionDTO;
import com.app.application.interfaces.ProductOptionService;
import com.app.application.mapper.ProductOptionMapper;
import com.app.domain.entity.OptionChoiceEntity;
import com.app.domain.entity.ProductOptionEntity;
import com.app.domain.entity.StoreEntity;
import com.app.domain.usecase.OptionChoiceUseCase;
import com.app.domain.usecase.ProductOptionUseCase;
import com.app.domain.usecase.StoreUseCase;
import com.app.infrastructure.exception.NotFoundException;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductOptionServiceImpl extends BaseServiceImpl<ProductOptionEntity, ProductOptionDTO>
        implements ProductOptionService {
    private ProductOptionUseCase useCase;
    private OptionChoiceUseCase optionChoiceUseCase;
    private StoreUseCase storeUseCase;
    private ProductOptionMapper productOptionMapper;

    ProductOptionServiceImpl(ProductOptionUseCase useCase, OptionChoiceUseCase optionChoiceUseCase,
            ProductOptionMapper productOptionMapper, StoreUseCase storeUseCase) {
        super(useCase, productOptionMapper, ProductOptionEntity.class);
        this.useCase = useCase;
        this.optionChoiceUseCase = optionChoiceUseCase;
        this.storeUseCase = storeUseCase;
        this.productOptionMapper = productOptionMapper;
    }

    @Override
    @Transactional
    public ApiResponse<ProductOptionDTO> create(ProductOptionDTO model) {
        ProductOptionEntity pOptionEntity = ProductOptionMapper.INSTANCE.toEntity(model);

        StoreEntity store = storeUseCase.findById(model.getStoreId())
                .orElseThrow(() -> new NotFoundException("Store", model.getStoreId()));
        pOptionEntity.setStore(store);
        ProductOptionEntity saveOption = useCase.save(pOptionEntity);

        if (!pOptionEntity.getChoices().isEmpty()) {
            pOptionEntity.getChoices().stream().forEach((OptionChoiceEntity e) -> {
                e.setProductOption(saveOption);
                optionChoiceUseCase.save(e);
            });
        }

        return new ApiResponse<>(productOptionMapper.toDTO(saveOption));
    }

    @Override
    public ProductOptionDTO getByOptionName(String optionName) {
        return productOptionMapper.toDTO(useCase.getByOptionName(optionName));
    }

    @Override
    public ApiResponse<List<ProductOptionDTO>> getAllByStoreId(String storeId) {
        return new ApiResponse<>(useCase.findAllByStoreId(storeId).stream().map(productOptionMapper::toDTO).toList());
    }

}
