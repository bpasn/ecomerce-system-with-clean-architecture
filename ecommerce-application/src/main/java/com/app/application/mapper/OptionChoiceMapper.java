package com.app.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.context.properties.bind.Name;

import com.app.application.dto.OptionChoiceDTO;
import com.app.domain.entity.EChoiceEffect;
import com.app.domain.entity.EStatusChoice;
import com.app.domain.entity.OptionChoiceEntity;

@Mapper
public interface OptionChoiceMapper extends BaseMapper<OptionChoiceDTO,OptionChoiceEntity>{
    OptionChoiceMapper INSTANCE = Mappers.getMapper(OptionChoiceMapper.class);

    @Override
    @Mapping(source = "status",target = "status",qualifiedByName = "stringToEStatus")
    @Mapping(source = "choiceEffect",target = "choiceEffect",qualifiedByName = "stringToEChoice")
    OptionChoiceEntity toEntity(OptionChoiceDTO dto);

    @Override
    @Mapping(source = "status",target = "status",qualifiedByName = "eStatusToString")
    @Mapping(source = "choiceEffect",target = "choiceEffect",qualifiedByName = "eChoiceToString")
    OptionChoiceDTO toDTO(OptionChoiceEntity entity);

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
