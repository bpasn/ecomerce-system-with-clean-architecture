package com.app.application.interfaces;

import com.app.application.dto.ProductGroupDTO;
import com.app.domain.entity.ProductGroupEntity;

public interface ProductGroupService extends BaseService<ProductGroupEntity,ProductGroupDTO> {
    ProductGroupDTO getByGroupname(String groupName);
}
