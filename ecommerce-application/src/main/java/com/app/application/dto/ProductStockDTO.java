package com.app.application.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.app.domain.models.EStatusStock;
import com.app.domain.models.EUnitType;

public interface ProductStockDTO {
    String getProductId();
    String getProductName();
    BigDecimal getProductPrice();
    LocalDateTime getProductCreated();
    LocalDateTime getProductUpdated();
    String getStockId();
    Integer getUnitQuantity();
    EUnitType getUnitType();
    EStatusStock getStockStatus();
    Integer getQuantity();
}
