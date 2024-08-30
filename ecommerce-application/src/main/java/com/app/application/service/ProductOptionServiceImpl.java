package com.app.application.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.app.application.dto.ProductOptionDTO;
import com.app.application.interfaces.ProductOptionService;
import com.app.application.mapper.ProductOptionMapper;
import com.app.domain.usecase.ProductOptionUseCase;

@Service
public class ProductOptionServiceImpl implements ProductOptionService {
    private ProductOptionUseCase useCase;

    ProductOptionServiceImpl(ProductOptionUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Page<ProductOptionDTO> getAll(int page, int size) {
        return useCase.findAllWithPageable(page, size).map(ProductOptionMapper.INSTANCE::toDTO);
    }

    @Override
    public ProductOptionDTO getByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }

    @Override
    public ProductOptionDTO getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public String create(ProductOptionDTO model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
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


}
