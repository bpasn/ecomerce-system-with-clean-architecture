package com.app.application.service;

import org.springframework.stereotype.Service;

import com.app.application.dto.StockDTO;
import com.app.application.interfaces.StockService;
import com.app.application.mapper.StockMapper;
import com.app.domain.models.Stock;
import com.app.domain.usecase.StockUseCase;
import com.app.infrastructure.exception.NotFoundException;

@Service
public class StockServiceImpl extends BaseServiceImpl<Stock, StockDTO> implements StockService {

    private final StockUseCase stockUseCase;

    public StockServiceImpl(StockUseCase stockUseCase, StockMapper stockMapper) {
        super(stockUseCase, stockMapper, Stock.class);
        this.stockUseCase = stockUseCase;
    }

    @Override
    public void updateStock(StockDTO stock) {
        Stock stockEntity = stockUseCase.findById(stock.getId())
                .orElseThrow(() -> new NotFoundException("Stock", stock.getId()));
        System.out.println("STOCK");
        stockEntity.setQuantity(stock.getQuantity());
        stockEntity.setStatus(stock.getStatus());
        stockEntity.setUnitQuantity(stock.getUnitQuantity());
        stockEntity.setUnitType(stock.getUnitType());
        stockUseCase.save(stockEntity);
    }

}
