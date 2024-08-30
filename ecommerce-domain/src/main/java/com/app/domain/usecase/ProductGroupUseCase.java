package com.app.domain.usecase;

import com.app.domain.entity.ProductGroupEntity;

public interface ProductGroupUseCase extends BaseUseCase<ProductGroupEntity>{
    boolean isGroupNameExists(String groupName);
}
