package com.app.application.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.app.application.dto.ProductsDTO;
import com.app.application.interfaces.ProductService;
import com.app.application.mapper.ProductMapper;
import com.app.domain.usecase.ProductUseCase;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductUseCase productUseCase;

    public ProductServiceImpl(ProductUseCase productUseCase) {
        this.productUseCase = productUseCase;
    }

    @Override
    public Page<ProductsDTO> getAll(int page, int size) {
        return productUseCase.findAllWithPageable(size, page).map(ProductMapper.INSTANCE::toDTO);
    }

    @Override
    public ProductsDTO getByName(String name) {
        return ProductMapper.INSTANCE.toDTO(productUseCase.findByName(name).orElse(null));
    }

    @Override
    public ProductsDTO getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public String create(ProductsDTO model) {
        productUseCase.insert(ProductMapper.INSTANCE.toEntity(model));
        return "Product has created";
    }

    @Override
    public void createAll(List<ProductsDTO> models) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createAll'");
    }

    @Override
    public void update(Long id, ProductsDTO model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
