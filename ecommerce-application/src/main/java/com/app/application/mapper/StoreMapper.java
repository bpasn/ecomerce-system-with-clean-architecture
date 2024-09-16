package com.app.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.app.application.dto.StoreDTO;
import com.app.domain.entity.StoreEntity;
import com.app.domain.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface StoreMapper extends BaseMapper<StoreDTO, StoreEntity> {
    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);

    @Override
    @Mapping(source = "user",target = "userId",qualifiedByName = "toUserId")
    StoreDTO toDTO(StoreEntity e);

    @Named("toUserId")
    default String toUserId(UserEntity user){
        return user.getId();
    }
}
