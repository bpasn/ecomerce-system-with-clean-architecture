package com.app.infrastructure.mapper;

import java.util.HashSet;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.app.domain.models.OptionChoice;
import com.app.domain.models.Product;
import com.app.domain.models.ProductCategories;
import com.app.domain.models.ProductImage;
import com.app.domain.models.ProductOption;
import com.app.domain.models.Stock;
import com.app.domain.models.Store;
import com.app.infrastructure.entity.OptionChoiceEntity;
import com.app.infrastructure.entity.ProductCategoriesEntity;
import com.app.infrastructure.entity.ProductEntity;
import com.app.infrastructure.entity.ProductImageEntity;
import com.app.infrastructure.entity.ProductOptionEntity;
import com.app.infrastructure.entity.StockEntity;
import com.app.infrastructure.entity.StoreEntity;

@Mapper(componentModel = "spring")
public interface ProductMapperInfra extends GenericMapper<ProductEntity, Product> {
    ProductMapperInfra INSTANCE = Mappers.getMapper(ProductMapperInfra.class);

    @Override
    @Mapping(source = "productImages", target = "productImages", qualifiedByName = "toProductImageList")
    @Mapping(source = "stock", target = "stock", qualifiedByName = "toStock")
    @Mapping(source = "categories", target = "categories", qualifiedByName = "toCategoriesSet")
    @Mapping(source = "productOptions", target = "productOptions", qualifiedByName = "toProductOptions")
    Product toModel(ProductEntity entity);

    @Named("toCategoriesSet")
    default Set<ProductCategories> toCategoriesSet(Set<ProductCategoriesEntity> entities) {
        return new HashSet<>(entities.stream().map(e -> addToCategories(e)).toList());
    }

    default ProductCategories addToCategories(ProductCategoriesEntity entity) {
        return new ProductCategories(
                entity.getId(),
                entity.getName(),
                toStoreModel(entity.getStore()));
    }

    default Store toStoreModel(StoreEntity store) {
        return new Store(store.getId(), store.getStoreName(), store.getCreatedAt(), store.getUpdatedAt());
    }

    @Named("toStock")
    default Stock toStock(StockEntity stock) {
        System.out.println(stock.getId());
        return new Stock(
                stock.getId(),
                stock.getUnitType(),
                stock.getUnitQuantity(),
                stock.getQuantity(),
                stock.getStatus(),
                stock.isReOrder());
    }

    @Named("toProductImageList")
    default Set<ProductImage> toProductImageList(Set<ProductImageEntity> entities) {
        if (entities == null) {
            return null;
        }
        return new HashSet<>(entities.stream().map(e -> addProductImage(e)).toList());

    }

    default ProductImage addProductImage(ProductImageEntity productImageEntity) {
        return new ProductImage(productImageEntity.getId(), productImageEntity.getSource());
    }

    @Named("toProductOptions")
    default Set<ProductOption> toProductOptoins(Set<ProductOptionEntity> entities) {
        return new HashSet<>(entities.stream().map(p -> addToProductOption(p)).toList());
    }

    default ProductOption addToProductOption(ProductOptionEntity entity) {
        return new ProductOption(
                entity.getId(),
                entity.getOptionName(),
                entity.isOneMustBeChosen(),
                entity.isManyCanBeChosen(),
                addToChoiceSet(entity.getChoices()),
                entity.getLengthSelect(),
                entity.getCreatedAt(),
                entity.getUpdatedAt());
    }

    default Set<OptionChoice> addToChoiceSet(Set<OptionChoiceEntity> entities) {
        return new HashSet<>(entities.stream().map(choice -> addTochoice(choice)).toList());
    }

    default OptionChoice addTochoice(OptionChoiceEntity entity) {
        return new OptionChoice(entity.getId(), entity.getName(), entity.getChoiceEffect(), entity.getPrice(),
                entity.getStatus());
    }
}
