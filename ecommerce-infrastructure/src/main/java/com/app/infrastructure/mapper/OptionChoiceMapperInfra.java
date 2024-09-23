package com.app.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.app.domain.models.OptionChoice;
import com.app.domain.models.ProductOption;
import com.app.infrastructure.entity.OptionChoiceEntity;
import com.app.infrastructure.entity.ProductOptionEntity;

@Mapper(componentModel = "spring")
public interface OptionChoiceMapperInfra extends GenericMapper<OptionChoiceEntity, OptionChoice> {
    OptionChoiceMapperInfra INSTANCE = Mappers.getMapper(OptionChoiceMapperInfra.class);

    @Override
    @Mapping(source = "productOption", target = "productOption", qualifiedByName = "toProductOptionModel")
    OptionChoice toModel(OptionChoiceEntity entity);

    @Override
    @Mapping(source = "productOption.choices", target = "productOption.choices",ignore = true)
    OptionChoiceEntity toEntity(OptionChoice model);

    @Named("toProductOptionModel")
    default ProductOption toProductOptionModel(ProductOptionEntity entity) {
        return new ProductOption(
                entity.getId(),
                entity.getOptionName(),
                entity.isOneMustBeChosen(),
                entity.isManyCanBeChosen(),
                entity.getLengthSelect(),
                entity.getChoices().stream().map((choice) -> {
                    return new OptionChoice(
                            choice.getId(),
                            choice.getName(),
                            choice.getChoiceEffect(),
                            choice.getPrice(),
                            choice.getStatus());
                }).toList(),
                entity.getCreatedAt(),
                entity.getUpdatedAt());
    }
}
