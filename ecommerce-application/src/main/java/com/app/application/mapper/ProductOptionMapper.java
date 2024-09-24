package com.app.application.mapper;

import com.app.application.dto.OptionChoiceDTO;
import com.app.application.dto.ProductOptionDTO;
import com.app.domain.models.OptionChoice;
import com.app.domain.models.ProductOption;
import com.app.domain.models.Store;

import java.util.HashSet;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface ProductOptionMapper extends BaseMapper<ProductOptionDTO, ProductOption>{
    ProductOptionMapper INSTANCE = Mappers.getMapper(ProductOptionMapper.class);

    @Override
    @Mapping(source = "store.id",target = "storeId")
    @Mapping(source = "choices",target="choices",qualifiedByName = "mapToChoiceSet")
    ProductOptionDTO toDTO(ProductOption entity);


    @Named("mapToChoiceSet")
    default Set<OptionChoiceDTO> mapToChoiceSet(Set<OptionChoice> choices){
        return new HashSet<>(choices.stream().map(choice -> addToChoice(choice)).toList());
    }

    default OptionChoiceDTO addToChoice(OptionChoice choice){
        return new OptionChoiceDTO(choice.getId(), choice.getName(), choice.getChoiceEffect().name(), choice.getPrice(),choice.getStatus().name());
    }
    
}
