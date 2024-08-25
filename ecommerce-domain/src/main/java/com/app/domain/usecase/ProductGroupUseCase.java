package com.app.domain.usecase;

import com.app.domain.entity.ProductGroupEntity;

public interface ProductGroupUseCase extends BaseUserCase<ProductGroupEntity>{
    boolean isGroupNameExists(String groupName);
}
