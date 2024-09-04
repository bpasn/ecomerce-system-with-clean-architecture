package com.app.infrastructure.usecase;

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
