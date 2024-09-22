package com.app.infrastructure.usecase;

import org.springframework.stereotype.Service;

import com.app.domain.models.Stock;
import com.app.domain.usecase.StockUseCase;
import com.app.infrastructure.entity.StockEntity;
import com.app.infrastructure.mapper.StockMapperInfra;
import com.app.infrastructure.repositories.StockJpaRepository;

@Service
public class StockUseCaseImple extends BaseUseCaseImpl<StockEntity,Stock> implements StockUseCase{

    public StockUseCaseImple(StockJpaRepository stockJpaRepository,StockMapperInfra mapper) {
        super(stockJpaRepository,mapper);
    }


    
}
