package com.app.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.app.domain.models.OptionChoice;
import com.app.infrastructure.entity.OptionChoiceEntity;

@Mapper(componentModel = "spring")
public interface OptionChoiceMapperInfra extends GenericMapper<OptionChoiceEntity, OptionChoice> {

    @Override
    @Mapping(target = "productOption.choices",ignore = true)
    OptionChoiceEntity toEntity(OptionChoice optionChoice);

    @Override
    @Mapping(target = "productOption.choices",ignore = true)
    OptionChoice toModel(OptionChoiceEntity optionChoiceEntity);
}
