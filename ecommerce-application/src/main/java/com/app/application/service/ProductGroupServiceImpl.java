package com.app.application.service;

import org.springframework.stereotype.Service;

import com.app.application.dto.ProductGroupDTO;
import com.app.application.interfaces.ProductGroupService;
import com.app.application.mapper.ProductGroupMapper;
import com.app.domain.entity.ProductGroupEntity;
import com.app.domain.usecase.ProductGroupUseCase;

@Service
public class ProductGroupServiceImpl extends BaseServiceImpl<ProductGroupEntity, ProductGroupDTO>
        implements ProductGroupService {

    public ProductGroupServiceImpl(
            ProductGroupUseCase productGroupUseCase,
            ProductGroupMapper productGroupMapper) {
        super(productGroupUseCase, productGroupMapper);
    }

    @Override
    public ProductGroupDTO getByGroupname(String groupName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByGroupname'");
    }

}
