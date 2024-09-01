package com.app.infrastructure.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.app.domain.entity.OptionChoiceEntity;
import com.app.domain.usecase.OptionChoiceUseCase;
import com.app.infrastructure.repositories.OptionChoiceJpaRepository;

@Service
public class OptionChoiceUseCaseImpl implements OptionChoiceUseCase {

    private final OptionChoiceJpaRepository optionChoiceJpaRepository;

    
    public OptionChoiceUseCaseImpl(OptionChoiceJpaRepository optionChoiceJpaRepository) {
        this.optionChoiceJpaRepository = optionChoiceJpaRepository;
    }

    @Override
    public OptionChoiceEntity insert(OptionChoiceEntity entity) {
       return optionChoiceJpaRepository.save(entity);
    }

    @Override
    public OptionChoiceEntity update(Long id, OptionChoiceEntity entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public List<OptionChoiceEntity> insertAll(List<OptionChoiceEntity> entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertAll'");
    }

    @Override
    public Optional<OptionChoiceEntity> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Page<OptionChoiceEntity> findAllWithPageable(int size, int page) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllWithPageable'");
    }

    @Override
    public List<OptionChoiceEntity> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
