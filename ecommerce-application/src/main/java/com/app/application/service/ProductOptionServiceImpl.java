package com.app.application.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.app.application.ApiResponse;
import com.app.application.dto.ProductOptionDTO;
import com.app.application.interfaces.ProductOptionService;
import com.app.application.mapper.ProductOptionMapper;
import com.app.domain.entity.ProductOptionEntity;
import com.app.domain.usecase.OptionChoiceUseCase;
import com.app.domain.usecase.ProductOptionUseCase;

import jakarta.transaction.Transactional;

@Service
public class ProductOptionServiceImpl extends BaseServiceImpl<ProductOptionEntity,ProductOptionDTO> implements ProductOptionService {
    private ProductOptionUseCase useCase;
    private OptionChoiceUseCase optionChoiceUseCase;
    private ProductOptionMapper productOptionMapper;
    ProductOptionServiceImpl(ProductOptionUseCase useCase, OptionChoiceUseCase optionChoiceUseCase,ProductOptionMapper productOptionMapper) {
        super(useCase, productOptionMapper);
        this.useCase = useCase;
        this.optionChoiceUseCase = optionChoiceUseCase;
        this.productOptionMapper = productOptionMapper;
    }
    @Override
    @Transactional
    public ApiResponse<ProductOptionDTO> create(ProductOptionDTO model) {
        ProductOptionEntity pOptionEntity = ProductOptionMapper.INSTANCE.toEntity(model);
        ProductOptionEntity saveOption = useCase.insert(pOptionEntity);
        
        if (!pOptionEntity.getChoices().isEmpty()) {
            pOptionEntity.getChoices().stream().forEach((e) -> {
                e.setProductOption(saveOption);
                optionChoiceUseCase.insert(e);
            });
        }

        return new ApiResponse<>(ProductOptionMapper.INSTANCE.toDTO(saveOption));
    }
    @Override
    public ProductOptionDTO getByOptionName(String optionName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByOptionName'");
    }


}
