package com.app.domain.projections;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.app.domain.enums.EStatusStock;
import com.app.domain.enums.EUnitType;

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
