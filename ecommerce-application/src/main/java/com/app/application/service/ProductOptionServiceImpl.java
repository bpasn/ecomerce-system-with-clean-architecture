package com.app.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.ProductOptionDTO;
import com.app.application.interfaces.ProductOptionService;
import com.app.application.mapper.ProductOptionMapper;
import com.app.domain.models.OptionChoice;
import com.app.domain.models.ProductOption;
import com.app.domain.models.Store;
import com.app.domain.usecase.OptionChoiceUseCase;
import com.app.domain.usecase.ProductOptionUseCase;
import com.app.domain.usecase.StoreUseCase;
import com.app.infrastructure.exception.NotFoundException;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductOptionServiceImpl extends BaseServiceImpl<ProductOption, ProductOptionDTO>
        implements ProductOptionService {
    private final ProductOptionUseCase productOptionUseCase;
    private final OptionChoiceUseCase optionChoiceUseCase;
    private final StoreUseCase storeUseCase;
    private final ProductOptionMapper productOptionMapper;

    private final EntityManager entityManager; 
    ProductOptionServiceImpl(ProductOptionUseCase productOptionUseCase, OptionChoiceUseCase optionChoiceUseCase,
            ProductOptionMapper productOptionMapper, StoreUseCase storeUseCase,EntityManager entityManager) {
        super(productOptionUseCase, productOptionMapper, ProductOption.class);
        this.productOptionUseCase = productOptionUseCase;
        this.optionChoiceUseCase = optionChoiceUseCase;
        this.storeUseCase = storeUseCase;
        this.productOptionMapper = productOptionMapper;
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public ApiResponse<ProductOptionDTO> create(ProductOptionDTO model) {
        try {
            ProductOption productOption = productOptionMapper.toModel(model);
            Store store = storeUseCase.findById(model.getStoreId())
                    .orElseThrow(() -> new NotFoundException("Store", model.getStoreId()));
            productOption.setStore(store);
            ProductOption saveOption = productOptionUseCase.save(productOption);
            if (productOption.getChoices() != null && !productOption.getChoices().isEmpty()) {
                productOption.getChoices().stream().forEach((OptionChoice choice) -> {
                    choice.setProductOption(saveOption);
                    optionChoiceUseCase.save(choice);
                });
            }
            return new ApiResponse<>(productOptionMapper.toDTO(saveOption));
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(null);
        }
    }

    @Override
    public ProductOptionDTO getByOptionName(String optionName) {
        return productOptionMapper.toDTO(productOptionUseCase.getByOptionName(optionName));
    }

    @Override
    public ApiResponse<List<ProductOptionDTO>> getAllByStoreId(String storeId) {
        List<ProductOption> productOptions = productOptionUseCase.findAllByStoreId(storeId);
        System.out.println(productOptions);
        return new ApiResponse<>(new ArrayList<>());
    }

}
