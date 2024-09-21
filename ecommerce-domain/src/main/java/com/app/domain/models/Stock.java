package com.app.domain.models;

public class Stock extends BaseModel {

    private Product product;

    private EUnitType unitType;
    private double unitQuantity;
    private int quantity;
    private EStatusStock status;
    private boolean reOrder;

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

}
