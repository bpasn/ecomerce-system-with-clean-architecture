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

    @ManyToMany
    @JoinTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<CategoriesEntity> categories = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<ProductImageEntity> productImages = new ArrayList<>();


    // @ManyToMany
    // @JoinTable(name = "group_product",joinColumns = @JoinColumn(name = "product_id"),inverseJoinColumns = @JoinColumn(name = "product_group_id"))
    // private List<ProductGroupEntity> productGroups = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "option_product",joinColumns = @JoinColumn(name = "product_id"),inverseJoinColumns = @JoinColumn(name = "product_option_id"))
    private List<ProductOptionEntity> productOptions = new ArrayList<>();

  

    public ProductEntity(){}

    public ProductEntity(String nameTH,String nameEN, String descriptionTH,String descriptionEN, double price,  List<CategoriesEntity> categories,
            List<ProductImageEntity> productImages) {
        this.nameTH = nameTH;
        this.nameEN = nameEN;
        this.descriptionTH = descriptionTH;
        this.descriptionEN = descriptionEN;
        this.price = price;
        this.categories = categories;
        this.productImages = productImages;
        // this.productGroups = productGroups;
    }

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

    public List<CategoriesEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesEntity> categories) {
        this.categories = categories;
    }

    public List<ProductOptionEntity> getProductOptions() {
        return productOptions;
    }

    public void setProductOptions(List<ProductOptionEntity> productOptions) {
        this.productOptions = productOptions;
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
        return "ProductEntity [nameTH=" + nameTH + ", nameEN=" + nameEN + ", descriptionTH=" + descriptionTH
                + ", descriptionEN=" + descriptionEN + ", price=" + price + ", stock=" + stock + ", categories="
                + categories + ", productImages=" + productImages + ", productOptions=" + productOptions
                + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }

   

    

}
