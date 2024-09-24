package com.app.infrastructure.entity;

import com.app.domain.models.EStatusStock;
import com.app.domain.models.EUnitType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity(name = "stocks")
public class StockEntity extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private ProductEntity product;

    @Column(name = "unit_type")
    @Enumerated(EnumType.STRING)
    private EUnitType unitType;
    @Column(name = "unit_quantity")
    private int unitQuantity;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private EStatusStock status;
    @Column(name = "re_order")
    private boolean reOrder;

    public boolean isReOrder() {
        return reOrder;
    }

    public void setReOrder(boolean reOrder) {
        this.reOrder = reOrder;
    }

    public StockEntity() {
        setUnitType(EUnitType.PIECE);
        setStatus(EStatusStock.IN_STOCK);
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
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

    @Override
    public String toString() {
        return "StockEntity [unitType=" + unitType + ", unitQuantity=" + unitQuantity + ", quantity=" + quantity
                + ", status=" + status + ", reOrder=" + reOrder + "]";
    }

}
