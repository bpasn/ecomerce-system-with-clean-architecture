package com.app.application.service;

import com.app.domain.models.Product;
import com.app.domain.usecase.ProductUseCase;
import com.app.infrastructure.exception.BaseException;
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
    private final ProductUseCase productUseCase;
    public StockServiceImpl(StockUseCase stockUseCase, StockMapper stockMapper,ProductUseCase productUseCase) {
        super(stockUseCase, stockMapper, Stock.class);
        this.stockUseCase = stockUseCase;
        this.productUseCase = productUseCase;
    }

    @Override
    public void updateStock(StockDTO stock) {
        Stock stockModel = stockUseCase.findById(stock.getId())
                .orElseThrow(() -> new NotFoundException("Stock", stock.getId()));

        Product product = productUseCase.findByStockId(stock.getId()).orElseThrow(() -> new BaseException("Product not found!!"));
        stockModel.setQuantity(stock.getQuantity());
        stockModel.setStatus(stock.getStatus());
        stockModel.setUnitQuantity(stock.getUnitQuantity());
        stockModel.setUnitType(stock.getUnitType());
        stockModel.setProduct(product);
        stockUseCase.save(stockModel);
    }

}
