package com.app.application.dto;

import com.app.domain.entity.EStatusStock;
import com.app.domain.entity.EUnitType;

public class StockDTO {
    EUnitType unitType;
    double unitQuantity;
    int quantity;
    EStatusStock status;
    boolean reOrder;

    public StockDTO() {
        setUnitType(EUnitType.PIECE);
        setStatus(EStatusStock.IN_STOCK);
        setReOrder(false);
    }

    public EUnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(EUnitType unitType) {
        this.unitType = unitType;
    }

    public double getUnitQuantity() {
        return unitQuantity;
    }

    public void setUnitQuantity(double unitQuantity) {
        this.unitQuantity = unitQuantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public EStatusStock getStatus() {
        return status;
    }

    public void setStatus(EStatusStock status) {
        this.status = status;
    }

    public boolean isReOrder() {
        return reOrder;
    }

    public void setReOrder(boolean reOrder) {
        this.reOrder = reOrder;
    }

    @Override
    public String toString() {
        return "StockDTO [unitType=" + unitType + ", unitQuantity=" + unitQuantity + ", quantity=" + quantity
                + ", status=" + status + ", reOrder=" + reOrder + "]";
    }

    
}
