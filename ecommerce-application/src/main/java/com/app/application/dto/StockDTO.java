package com.app.application.dto;

import com.app.domain.models.EStatusStock;
import com.app.domain.models.EUnitType;

public class StockDTO {
    String id;
    EUnitType unitType;
    int unitQuantity;
    int quantity;
    EStatusStock status;
    boolean reOrder;

    public StockDTO() {
        setUnitType(EUnitType.PIECE);
        setStatus(EStatusStock.IN_STOCK);
        setReOrder(false);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EUnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(EUnitType unitType) {
        this.unitType = unitType;
    }

    public int getUnitQuantity() {
        return unitQuantity;
    }

    public void setUnitQuantity(int unitQuantity) {
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
