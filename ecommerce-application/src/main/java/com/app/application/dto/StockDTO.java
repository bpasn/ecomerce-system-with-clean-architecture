package com.app.application.dto;

import com.app.domain.enums.EStatusStock;
import com.app.domain.enums.EUnitType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class StockDTO {
    String id;
    @Pattern(regexp = "^(PIECE)|(GRAM)|(KILOGRAM)",message = "Unit type allows only PIECE, GRAM, or KILOGRAM")
    @NotEmpty
    EUnitType unitType;
    @Pattern(regexp = "^\\d",message = "UnitQuantity must be a number")
    @NotEmpty
    int unitQuantity;
    @Pattern(regexp = "^\\d",message = "UnitQuantity must be a number")
    @NotEmpty
    int quantity;
    @Pattern(regexp = "^(IN_STOCK)|(OUT_OF_STOCK)|(LOW_STOCK)",message = "status allows only IN_STOCK, LOW_STOCK, or OUT_OF_STOCK")
    @NotEmpty
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
