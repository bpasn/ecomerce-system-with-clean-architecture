package com.app.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.OptionChoiceDTO;
import com.app.application.dto.ProductOptionDTO;
import com.app.application.interfaces.ProductOptionService;
import com.app.application.mapper.OptionChoiceMapper;
import com.app.application.mapper.ProductOptionMapper;
import com.app.domain.models.OptionChoice;
import com.app.domain.models.ProductOption;
import com.app.domain.models.Store;
import com.app.domain.usecase.OptionChoiceUseCase;
import com.app.domain.usecase.ProductOptionUseCase;
import com.app.domain.usecase.StoreUseCase;
import com.app.infrastructure.exception.BaseException;
import com.app.infrastructure.exception.NotFoundException;

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


    ProductOptionServiceImpl(ProductOptionUseCase productOptionUseCase, OptionChoiceUseCase optionChoiceUseCase,
            ProductOptionMapper productOptionMapper, StoreUseCase storeUseCase) {
        super(productOptionUseCase, productOptionMapper, ProductOption.class);
        this.productOptionUseCase = productOptionUseCase;
        this.optionChoiceUseCase = optionChoiceUseCase;
        this.storeUseCase = storeUseCase;
        this.productOptionMapper = productOptionMapper;
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
            System.out.println(saveOption.getChoices());

            if (model.getChoices() != null && !model.getChoices().isEmpty()) {
                model.getChoices().stream().forEach((OptionChoiceDTO choice) -> {
                    OptionChoice optionChoice = OptionChoiceMapper.INSTANCE.toModel(choice);
                    optionChoice.setProductOption(saveOption);
                    optionChoiceUseCase.save(optionChoice);
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
        System.out.println();
        return new ApiResponse<>(productOptions.stream().map(productOptionMapper::toDTO).toList());
    }

    @Override
    public void delete(String id){
        productOptionUseCase.delete(id);
    }
}
