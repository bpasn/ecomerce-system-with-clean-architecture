package com.app.infrastructure.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.app.domain.entity.StockEntity;
import com.app.domain.usecase.StockUseCase;
import com.app.infrastructure.repositories.StockJpaRepository;

@Service
public class StockUseCaseImple extends BaseUseCaseImpl<StockEntity> implements StockUseCase {

    public StockUseCaseImple(StockJpaRepository stockJpaRepository) {
        super(stockJpaRepository);
    }
    
}
