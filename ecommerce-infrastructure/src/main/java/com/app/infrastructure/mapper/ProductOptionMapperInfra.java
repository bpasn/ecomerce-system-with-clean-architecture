package com.app.infrastructure.mapper;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.app.domain.models.OptionChoice;
import com.app.domain.models.ProductOption;
import com.app.infrastructure.entity.OptionChoiceEntity;
import com.app.infrastructure.entity.ProductOptionEntity;

@Mapper(componentModel = "spring",uses = {OptionChoiceMapperInfra.class})
public interface ProductOptionMapperInfra extends GenericMapper<ProductOptionEntity, ProductOption> {

  @Override
  @Mapping(target = "choices",source = "choices")
  ProductOption toModel(ProductOptionEntity entity);

  @Override
  @Mapping(target = "choices",ignore = true)
  ProductOptionEntity toEntity(ProductOption model);
//
//
//  @Named("mappingChoiceListToModel")
//  default Set<OptionChoice> mappingChoiceListToModel(Set<OptionChoiceEntity> entity){
//    return new HashSet<>(entity.stream().map(opEntity -> addToOptionChoice(opEntity)).collect(Collectors.toList()));
//  }
//
//  default OptionChoice addToOptionChoice(OptionChoiceEntity option){
//    return new OptionChoice(option.getId(), option.getName(),option.getChoiceEffect(), option.getPrice(),option.getStatus());
//  }
}
