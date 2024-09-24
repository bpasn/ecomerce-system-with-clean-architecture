package com.app.domain.projections;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.app.domain.models.EStatusStock;
import com.app.domain.models.EUnitType;

public interface StockProductProjection {
    String getProductId();
    String getProductName();
    String getProductImage();
    BigDecimal getProductPrice();
    LocalDateTime getProductCreated();
    LocalDateTime getProductUpdated();
    String getStockId();
    Integer getUnitQuantity();
    EUnitType getUnitType();
    EStatusStock getStockStatus();
    Integer getQuantity();
}
