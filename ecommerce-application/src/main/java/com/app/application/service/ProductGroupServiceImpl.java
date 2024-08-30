package com.app.application.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.app.application.dto.ProductGroupDTO;
import com.app.application.interfaces.ProductGroupService;
import com.app.application.mapper.ProductGroupMapper;
import com.app.domain.usecase.ProductGroupUseCase;

@Service
public class ProductGroupServiceImpl implements ProductGroupService {
    private final ProductGroupUseCase productGroupUseCase;

    ProductGroupServiceImpl(ProductGroupUseCase productGroupUseCase) {
        this.productGroupUseCase = productGroupUseCase;
    }


    @Override
    public Page<ProductGroupDTO> getAll(int page, int size) {
        return productGroupUseCase.findAllWithPageable(size, page).map(ProductGroupMapper.INSTANCE::toDTO);
    }

    @Override
    public ProductGroupDTO getByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }

    @Override
    public ProductGroupDTO getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public String create(ProductGroupDTO model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public void createAll(List<ProductGroupDTO> models) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createAll'");
    }

    @Override
    public void update(Long id, ProductGroupDTO model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    

}
