package com.app.infrastructure.usecase;

import org.springframework.stereotype.Service;

import com.app.domain.entity.OptionChoiceEntity;
import com.app.domain.usecase.OptionChoiceUseCase;
import com.app.infrastructure.repositories.OptionChoiceJpaRepository;

@Service
public class OptionChoiceUseCaseImpl extends BaseUseCaseImpl<OptionChoiceEntity> implements OptionChoiceUseCase {
    
    public OptionChoiceUseCaseImpl(OptionChoiceJpaRepository optionChoiceJpaRepository) {
        super(optionChoiceJpaRepository);
    }

   
    
}
