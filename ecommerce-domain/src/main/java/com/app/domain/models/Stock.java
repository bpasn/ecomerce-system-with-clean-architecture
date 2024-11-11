package com.app.domain.models;

import com.app.domain.enums.EStatusStock;
import com.app.domain.enums.EUnitType;

import java.time.LocalDateTime;

public class Stock extends BaseModel {
    private Product product;
    private EUnitType unitType;
    private int unitQuantity;
    private int quantity;
    private EStatusStock status;
    private boolean reOrder;
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
    public boolean isReOrder() {
        return reOrder;
    }

    public void setReOrder(boolean reOrder) {
        this.reOrder = reOrder;
    }

    public Stock() {
        setUnitType(EUnitType.PIECE);
        setStatus(EStatusStock.IN_STOCK);
    }
    
    

    public Stock(String id,EUnitType unitType, int unitQuantity, int quantity, EStatusStock status, boolean reOrder) {
        setId(id);
        this.unitType = unitType;
        this.unitQuantity = unitQuantity;
        this.quantity = quantity;
        this.status = status;
        this.reOrder = reOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Stock [unitType=" + unitType + ", unitQuantity=" + unitQuantity + ", quantity=" + quantity + ", status="
                + status + ", reOrder=" + reOrder + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((unitType == null) ? 0 : unitType.hashCode());
        long temp;
        temp = Double.doubleToLongBits(unitQuantity);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + quantity;
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + (reOrder ? 1231 : 1237);
        result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
        result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Stock other = (Stock) obj;
        if (unitType != other.unitType)
            return false;
        if (Double.doubleToLongBits(unitQuantity) != Double.doubleToLongBits(other.unitQuantity))
            return false;
        if (quantity != other.quantity)
            return false;
        if (status != other.status)
            return false;
        if (reOrder != other.reOrder)
            return false;
        if (createdAt == null) {
            if (other.createdAt != null)
                return false;
        } else if (!createdAt.equals(other.createdAt))
            return false;
        if (updatedAt == null) {
            if (other.updatedAt != null)
                return false;
        } else if (!updatedAt.equals(other.updatedAt))
            return false;
        return true;
    }

    
}
