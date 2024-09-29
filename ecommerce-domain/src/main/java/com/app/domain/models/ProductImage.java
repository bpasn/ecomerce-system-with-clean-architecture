package com.app.domain.models;

public class ProductImage extends BaseModel {
    private String source;
    private Product product;

    public ProductImage() {}

    public ProductImage(String source) {
        this.source = source;
    }
    public ProductImage(String id,String source) {
        setId(id);
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductImage [source=" + source + "]";
    }

    
}
