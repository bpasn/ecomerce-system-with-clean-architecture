package com.app.infrastructure.mapper;

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
import com.app.domain.projections.CategoryWithProductProjection;
import com.app.infrastructure.entity.OptionChoiceEntity;
import com.app.infrastructure.entity.ProductCategoriesEntity;
import com.app.infrastructure.entity.ProductEntity;
import com.app.infrastructure.entity.ProductImageEntity;
import com.app.infrastructure.entity.ProductOptionEntity;
import com.app.infrastructure.entity.StockEntity;

import java.util.Set;
import java.util.HashSet;
import java.util.List;

@Mapper(componentModel = "spring",uses = {
        ProductMapperInfra.class,
        ProductOptionMapperInfra.class
})
public interface ProductCategoryMapperInfra extends GenericMapper<ProductCategoriesEntity, ProductCategories> {

    @Mapping(source = "id", target = "categoryId")
    @Mapping(source = "name", target = "categoryName")
    @Mapping(source = "products", target = "products")
    CategoryWithProductProjection toCategoryWithProduct(ProductCategoriesEntity productCategoriesEntity);

//    @Named("toProductModel")
//    default List<Product> toProductModel(List<ProductEntity> entities) {
//        return entities.stream().map(e -> addProductToCategory(e)).toList();
//    }

//    default Product addProductToCategory(ProductEntity entity) {
//        Product product = new Product();
//        product.setId(entity.getId());
//        product.setNameTH(entity.getNameTH());
//        product.setNameEN(entity.getNameEN());
//        product.setDescriptionEN(entity.getDescriptionEN());
//        product.setDescriptionTH(entity.getDescriptionTH());
//        product.setPrice(entity.getPrice());
//        product.setStock(addStockToProduct(entity.getStock()));
//        product.setProductImages(addImageListToProduct(entity.getProductImages()));
//        product.setProductOptions(addOptionListToProduct(entity.getProductOptions()));
//        return product;
//    }
//
//    default Stock addStockToProduct(StockEntity stock) {
//        return new Stock(stock.getId(), stock.getUnitType(), stock.getUnitQuantity(), stock.getQuantity(),
//                stock.getStatus(), stock.isReOrder());
//    }
//
//    default Set<ProductImage> addImageListToProduct(Set<ProductImageEntity> et) {
//        return new HashSet<>(et.stream().map(e -> addImageToProduct(e)).toList());
//    }
//
//    default ProductImage addImageToProduct(ProductImageEntity entity) {
//        ProductImage image = new ProductImage(entity.getId(), entity.getSource());
//        System.out.println("SOURCE : " + image.getSource());
//
//        return image;
//    }
//
//    default Set<ProductOption> addOptionListToProduct(Set<ProductOptionEntity> en) {
//        return new HashSet<>(en.stream().map(e -> addOptionToProduct(e)).toList());
//    }
//
//    default ProductOption addOptionToProduct(ProductOptionEntity en) {
//        return new ProductOption(
//                en.getId(),
//                en.getOptionName(),
//                en.isOneMustBeChosen(),
//                en.isManyCanBeChosen(),
//                addChoiceListToOption(en.getChoices()),
//                en.getLengthSelect(),
//                en.getCreatedAt(),
//                 en.getUpdatedAt());
//    }
//
//    default Set<OptionChoice> addChoiceListToOption(Set<OptionChoiceEntity> en) {
//        return new HashSet<>(en.stream().map(e -> addChoiceToOption(e)).toList());
//    }
//
//    default OptionChoice addChoiceToOption(OptionChoiceEntity en) {
//        return new OptionChoice(en.getId(), en.getName(), en.getChoiceEffect(), en.getPrice(), en.getStatus());
//    }

}
