package com.app.application.mapper;

import com.app.application.dto.UserDTO;
import com.app.domain.entity.UserEntity;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<UserDTO,UserEntity> {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
}
