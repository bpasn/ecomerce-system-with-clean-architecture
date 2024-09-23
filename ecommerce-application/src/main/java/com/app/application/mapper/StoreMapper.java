package com.app.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.app.application.dto.StoreDTO;
import com.app.domain.models.Store;
import com.app.domain.models.User;

@Mapper(componentModel = "spring")
public interface StoreMapper extends BaseMapper<StoreDTO, Store> {
    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);

    @Override
    // @Mapping(source = "user",target = "userId",qualifiedByName = "toUserId")
    StoreDTO toDTO(Store e);

    // @Named("toUserId")
    // default String toUserId(User user){
    //     return user.getId();
    // }
}
