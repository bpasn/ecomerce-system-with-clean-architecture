package com.app.application.mapper;

import com.app.application.dto.UserDTO;
import com.app.domain.models.User;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<UserDTO,User> {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
}
