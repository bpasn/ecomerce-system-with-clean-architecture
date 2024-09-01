package com.app.application.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.app.application.dto.ProductOptionDTO;
import com.app.application.interfaces.ProductOptionService;
import com.app.application.mapper.ProductOptionMapper;
import com.app.domain.entity.ProductOptionEntity;
import com.app.domain.usecase.OptionChoiceUseCase;
import com.app.domain.usecase.ProductOptionUseCase;

import jakarta.transaction.Transactional;

@Service
public class ProductOptionServiceImpl implements ProductOptionService {
    private ProductOptionUseCase useCase;
    private OptionChoiceUseCase optionChoiceUseCase;

    ProductOptionServiceImpl(ProductOptionUseCase useCase, OptionChoiceUseCase optionChoiceUseCase) {
        this.useCase = useCase;
        this.optionChoiceUseCase = optionChoiceUseCase;
    }

    @Override
    public Page<ProductOptionDTO> getAllWithPage(int page, int size) {
        return useCase.findAllWithPageable(size, page).map(ProductOptionMapper.INSTANCE::toDTO);
    }

    @Override
    public List<ProductOptionDTO> getAll() {
        return useCase.findAll().stream().map(ProductOptionMapper.INSTANCE::toDTO).toList();
    }

    @Override
    public ProductOptionDTO getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    @Transactional
    public ProductOptionDTO create(ProductOptionDTO model) {
        ProductOptionEntity pOptionEntity = ProductOptionMapper.INSTANCE.toEntity(model);
        ProductOptionEntity saveOption = useCase.insert(pOptionEntity);
        
        if (!pOptionEntity.getChoices().isEmpty()) {
            pOptionEntity.getChoices().stream().forEach((e) -> {
                e.setProductOption(saveOption);
                optionChoiceUseCase.insert(e);
            });
        }

        return ProductOptionMapper.INSTANCE.toDTO(saveOption);
    }

    @Override
    public void createAll(List<ProductOptionDTO> models) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createAll'");
    }

    @Override
    public void update(Long id, ProductOptionDTO model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ProductOptionDTO getByOptionName(String optionName) {
        return ProductOptionMapper.INSTANCE.toDTO(useCase.getByOptionName(optionName));
    }

}
