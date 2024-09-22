package com.app.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.app.domain.models.OptionChoice;
import com.app.infrastructure.entity.OptionChoiceEntity;

@Mapper(componentModel = "spring")
public interface OptionChoiceMapperInfra extends GenericMapper<OptionChoiceEntity,OptionChoice>{
    OptionChoiceMapperInfra INSTANCE = Mappers.getMapper(OptionChoiceMapperInfra.class);

}
