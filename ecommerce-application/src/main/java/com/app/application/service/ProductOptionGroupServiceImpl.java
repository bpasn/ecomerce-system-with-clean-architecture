package com.app.application.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.app.application.handler.CustomExceptionHandler;
import com.app.application.handler.EnumCode;
import com.app.application.interfaces.ProductOptionGroupService;
import com.app.application.mapper.ProductOptionGroupMapper;
import com.app.application.mapper.ProductOptionMapper;
import com.app.domain.entity.ProductOptionEntity;
import com.app.domain.entity.ProductOptionGroupEntity;
import com.app.infrastructure.repositories.ProductOptionGroupRepository;

@Service
public class ProductOptionGroupServiceImpl implements ProductOptionGroupService {
    private final ProductOptionGroupRepository repository;
    private final ProductOptionServiceImpl productOptionServiceImpl;


    ProductOptionGroupServiceImpl(ProductOptionGroupRepository repository,ProductOptionServiceImpl productOptionServiceImpl) {
        this.repository = repository;
        this.productOptionServiceImpl = productOptionServiceImpl;
    }


    @Override
    public ProductOptionGroupEntity getByName(String name) {
        return repository.getByGroupName(name).orElseThrow(() -> new CustomExceptionHandler("ProductGroup with name " + name + " not found", EnumCode.BAD_REQUEST));
    }


    @Override
    public Page<ProductOptionGroupEntity> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }


    @Override
    public ProductOptionGroupEntity getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }


    @Override
    public String create(ProductOptionGroupEntity model) {
        ProductOptionGroupEntity entity = new ProductOptionGroupEntity();
        entity.setGroupName(model.getGroupName());
        List<ProductOptionEntity> productOptionEntity = model.getProductOptions().stream().map((e) -> {
            ProductOptionEntity po = new ProductOptionEntity();
            po.setOptionName(e.getOptionName());
            po.setPrice(e.getPrice());
            po.setProductOptionGroup(entity);
            return po;
        }).toList();
        productOptionServiceImpl.createAll(productOptionEntity.stream().map(ProductOptionMapper.INSTANCE::toDTO).toList());
        entity.setProductOptions(productOptionEntity);
        repository.save(entity);

        
        
        return "ProductOptionGroup has created";
    }


    @Override
    public void createAll(List<ProductOptionGroupEntity> models) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createAll'");
    }


    @Override
    public void update(Long id, ProductOptionGroupEntity model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }


    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
