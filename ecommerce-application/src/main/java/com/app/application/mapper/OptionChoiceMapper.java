package com.app.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.app.application.dto.OptionChoiceDTO;
import com.app.domain.enums.EChoiceEffect;
import com.app.domain.enums.EStatusChoice;
import com.app.domain.models.OptionChoice;

@Mapper(componentModel = "spring")
public interface OptionChoiceMapper extends BaseMapper<OptionChoiceDTO,OptionChoice>{
    OptionChoiceMapper INSTANCE = Mappers.getMapper(OptionChoiceMapper.class);

    @Override
    @Mapping(source = "status",target = "status",qualifiedByName = "stringToEStatus")
    @Mapping(source = "choiceEffect",target = "choiceEffect",qualifiedByName = "stringToEChoice")
    OptionChoice toModel(OptionChoiceDTO dto);

    @Override
    @Mapping(source = "status",target = "status",qualifiedByName = "eStatusToString")
    @Mapping(source = "choiceEffect",target = "choiceEffect",qualifiedByName = "eChoiceToString")
    OptionChoiceDTO toDTO(OptionChoice entity);

    @Named("stringToEStatus")
    default EStatusChoice stringToEStatus(String status){
        for(EStatusChoice s : EStatusChoice.values()){
            if(s.name().equals(status)){
                return s;
            }
        }
        return null;
    }
    @Named("stringToEChoice")
    default EChoiceEffect stringToEChoice(String e){
        for(EChoiceEffect choice : EChoiceEffect.values()){
            if(choice.name().equals(e)){
                return choice;
            }
        }
        return null;
    }
    @Named("eStatusToString")
    default String eStatusToString(EStatusChoice status){
        return status.name();
    }    
    @Named("eChoiceToString")
    default String eChoiceToString(EChoiceEffect choice){
        return choice.name();
    }    
}
