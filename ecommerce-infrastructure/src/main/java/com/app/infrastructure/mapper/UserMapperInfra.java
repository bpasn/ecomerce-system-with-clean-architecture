package com.app.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.app.domain.models.User;
import com.app.infrastructure.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapperInfra extends GenericMapper<UserEntity, User> {
    public UserMapperInfra INSTANCE = Mappers.getMapper(UserMapperInfra.class);

    @Override
    @Mapping(target = "stores", ignore = true)
    UserEntity toEntity(User model);

    @Override
    @Mapping(target = "stores", ignore = true)
    User toModel(UserEntity entity);
}
