package com.app.application.interfaces;

import com.app.application.dto.StockDTO;
import com.app.domain.entity.StockEntity;

public interface StockService extends BaseService<StockEntity, StockDTO> {
    void updateStock(StockDTO stock);
}
