package com.app.domain.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

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
    private double price;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private StockEntity stock;
    
    public ProductEntity(){}

    public ProductEntity(String nameTH,String nameEN, String descriptionTH,String descriptionEN, double price,  List<CategoriesEntity> categories,
            List<ProductImageEntity> productImages, List<ProductGroupEntity> productGroups) {
        this.nameTH = nameTH;
        this.nameEN = nameEN;
        this.descriptionTH = descriptionTH;
        this.descriptionEN = descriptionEN;
        this.price = price;
        this.categories = categories;
        this.productImages = productImages;
        this.productGroups = productGroups;
    }

    @ManyToMany
    @JoinTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<CategoriesEntity> categories = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<ProductImageEntity> productImages = new ArrayList<>();


    @ManyToMany
    @JoinTable(name = "group_product",joinColumns = @JoinColumn(name = "product_id"),inverseJoinColumns = @JoinColumn(name = "product_group_id"))
    private List<ProductGroupEntity> productGroups = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "option_product",joinColumns = @JoinColumn(name = "product_id"),inverseJoinColumns = @JoinColumn(name = "product_option_id"))
    private List<ProductOptionEntity> productOptions = new ArrayList<>();


    public List<ProductImageEntity> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImageEntity> productImages) {
        this.productImages = productImages;
    }

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", updatable = false)
    private LocalDateTime updatedAt;

    public String getNameTH() {
        return nameTH;
    }

    public void setNameTH(String nameTH) {
        this.nameTH = nameTH;
    }

   

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
    public StockEntity getStock() {
        return stock;
    }

    public void setStock(StockEntity stock) {
        this.stock = stock;
    }

    public List<ProductGroupEntity> getProductGroups() {
        return productGroups;
    }

    public void setProductGroups(List<ProductGroupEntity> productGroups) {
        this.productGroups = productGroups;
    }

    public List<CategoriesEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesEntity> categories) {
        this.categories = categories;
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

    @Override
    public String toString() {
        return "ProductEntity [nameTH=" + nameTH + ", nameEN=" + nameEN + ", descriptionTH=" + descriptionTH
                + ", descriptionEN=" + descriptionEN + ", price=" + price + ", stock="
                + stock + ", categories=" + categories + ", productImages=" + productImages + ", productGroups="
                + productGroups + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nameTH == null) ? 0 : nameTH.hashCode());
        result = prime * result + ((nameEN == null) ? 0 : nameEN.hashCode());
        result = prime * result + ((descriptionTH == null) ? 0 : descriptionTH.hashCode());
        result = prime * result + ((descriptionEN == null) ? 0 : descriptionEN.hashCode());
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((stock == null) ? 0 : stock.hashCode());
        result = prime * result + ((categories == null) ? 0 : categories.hashCode());
        result = prime * result + ((productImages == null) ? 0 : productImages.hashCode());
        result = prime * result + ((productGroups == null) ? 0 : productGroups.hashCode());
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
        if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
            return false;
        if (stock == null) {
            if (other.stock != null)
                return false;
        } else if (!stock.equals(other.stock))
            return false;
        if (categories == null) {
            if (other.categories != null)
                return false;
        } else if (!categories.equals(other.categories))
            return false;
        if (productImages == null) {
            if (other.productImages != null)
                return false;
        } else if (!productImages.equals(other.productImages))
            return false;
        if (productGroups == null) {
            if (other.productGroups != null)
                return false;
        } else if (!productGroups.equals(other.productGroups))
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
