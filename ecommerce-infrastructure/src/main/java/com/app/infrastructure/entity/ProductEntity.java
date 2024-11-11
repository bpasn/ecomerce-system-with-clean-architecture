package com.app.infrastructure.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class ProductEntity extends BaseEntity {
    @Column(name = "name_th")
    private String nameTH;
    @Column(name = "name_en")
    private String nameEN;
    @Column(name = "description_th")
    private String descriptionTH;
    @Column(name = "description_en")
    private String descriptionEN;
    @Column(name = "price")
    private BigDecimal price;

    @OneToOne(mappedBy = "product", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private StockEntity stock;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private StoreEntity store;

   
    @ManyToMany
    @JoinTable(name = "product_product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<ProductCategoriesEntity> categories = new HashSet<>();

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private Set<ProductImageEntity> productImages = new HashSet<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "product_product_option", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "product_option_id"))
    private Set<ProductOptionEntity> productOptions = new HashSet<>();

    public ProductEntity() {
    }

    public ProductEntity(String nameTH, String nameEN, String descriptionTH, String descriptionEN, BigDecimal price,
            Set<ProductCategoriesEntity> categories,
            Set<ProductImageEntity> productImages) {
        this.nameTH = nameTH;
        this.nameEN = nameEN;
        this.descriptionTH = descriptionTH;
        this.descriptionEN = descriptionEN;
        this.price = price;
        this.categories = categories;
        this.productImages = productImages;
        // this.productGroups = productGroups;
    }

    public Set<ProductImageEntity> getProductImages() {
        return productImages;
    }

    public void setProductImages(Set<ProductImageEntity> productImages) {
        this.productImages = productImages;
    }

    public String getNameTH() {
        return nameTH;
    }

    public void setNameTH(String nameTH) {
        this.nameTH = nameTH;
    }

    public String getNameEN() {
        return nameEN;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }

    public String getDescriptionTH() {
        return descriptionTH;
    }

    public void setDescriptionTH(String descriptionTH) {
        this.descriptionTH = descriptionTH;
    }

    public String getDescriptionEN() {
        return descriptionEN;
    }

    public void setDescriptionEN(String descriptionEN) {
        this.descriptionEN = descriptionEN;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public StockEntity getStock() {
        return stock;
    }

    public void setStock(StockEntity stock) {
        this.stock = stock;
    }

    public Set<ProductCategoriesEntity> getCategories() {
        return categories;
    }

    public void setCategories(Set<ProductCategoriesEntity> categories) {
        this.categories = categories;
    }

    public Set<ProductOptionEntity> getProductOptions() {
        return productOptions;
    }

    public void setProductOptions(Set<ProductOptionEntity> productOptions) {
        this.productOptions = productOptions;
    }
    public StoreEntity getStore() {
        return store;
    }

    public void setStore(StoreEntity store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "ProductEntity [nameTH=" + nameTH + ", nameEN=" + nameEN + ", descriptionTH=" + descriptionTH
                + ", descriptionEN=" + descriptionEN + ", price=" + price + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nameTH == null) ? 0 : nameTH.hashCode());
        result = prime * result + ((nameEN == null) ? 0 : nameEN.hashCode());
        result = prime * result + ((descriptionTH == null) ? 0 : descriptionTH.hashCode());
        result = prime * result + ((descriptionEN == null) ? 0 : descriptionEN.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
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
        ProductEntity other = (ProductEntity) obj;
        if (nameTH == null) {
            if (other.nameTH != null)
                return false;
        } else if (!nameTH.equals(other.nameTH))
            return false;
        if (nameEN == null) {
            if (other.nameEN != null)
                return false;
        } else if (!nameEN.equals(other.nameEN))
            return false;
        if (descriptionTH == null) {
            if (other.descriptionTH != null)
                return false;
        } else if (!descriptionTH.equals(other.descriptionTH))
            return false;
        if (descriptionEN == null) {
            if (other.descriptionEN != null)
                return false;
        } else if (!descriptionEN.equals(other.descriptionEN))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        return true;
    }

    

}
