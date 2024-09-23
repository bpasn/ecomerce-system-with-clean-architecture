package com.app.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.app.domain.models.Store;
import com.app.domain.models.User;
import com.app.infrastructure.entity.StoreEntity;
import com.app.infrastructure.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface StoreMapperInfra extends GenericMapper<StoreEntity, Store> {
    public StoreMapperInfra INSTANCE = Mappers.getMapper(StoreMapperInfra.class);

    @Override
    @Mapping(target = "user", source = "user")
    // @Mapping(target = "products",ignore=true)
    // @Mapping(target = "productCategories",ignore=true)
    // @Mapping(target = "productOption",ignore=true)
    StoreEntity toEntity(Store model);

    @Override
    @Mapping(target = "user", source = "user", qualifiedByName = "toUserModel")
    // @Mapping(target = "products",ignore=true)
    // @Mapping(target = "productCategories",ignore=true)
    // @Mapping(target = "productOption",ignore=true)
    Store toModel(StoreEntity entity);

    @Named("toUserModel")
    default User toUserModel(UserEntity userEntity) {
        return new User(userEntity.getId(), userEntity.getEmail(), userEntity.getName(), userEntity.getPassword());
    }

}
