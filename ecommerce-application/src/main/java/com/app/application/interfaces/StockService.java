package com.app.application.interfaces;

import com.app.application.dto.StockDTO;
import com.app.domain.models.Stock;

public interface StockService extends BaseService<Stock, StockDTO> {
    void updateStock(StockDTO stock);
}
