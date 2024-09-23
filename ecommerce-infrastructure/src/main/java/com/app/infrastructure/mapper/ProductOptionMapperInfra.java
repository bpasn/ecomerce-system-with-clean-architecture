package com.app.infrastructure.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.app.domain.models.Product;
import com.app.domain.models.ProductCategories;
import com.app.domain.models.ProductImage;
import com.app.domain.models.ProductOption;
import com.app.domain.models.Store;
import com.app.domain.models.User;
import com.app.infrastructure.entity.ProductCategoriesEntity;
import com.app.infrastructure.entity.ProductEntity;
import com.app.infrastructure.entity.ProductImageEntity;
import com.app.infrastructure.entity.ProductOptionEntity;
import com.app.infrastructure.entity.StoreEntity;
import com.app.infrastructure.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface ProductOptionMapperInfra extends GenericMapper<ProductOptionEntity, ProductOption> {
  ProductOptionMapperInfra INSTANCE = Mappers.getMapper(ProductOptionMapperInfra.class);

  @Override
  @Mapping(target = "choices", ignore = true)
  @Mapping(target = "products", ignore = true)
  @Mapping(target = "store", ignore = true)
  ProductOptionEntity toEntity(ProductOption model);

  @Override
  @Mapping(target = "choices", ignore = true)
  @Mapping(target = "products", source = "products", qualifiedByName = "toProductList")
  @Mapping(target = "store", source = "store", qualifiedByName = "toStore")
  ProductOption toModel(ProductOptionEntity entity);

  @Named("toProductList")
  default List<Product> toProductList(List<ProductEntity> productEntities) {
    return toProductsListFormEntity(productEntities);
  }

  @Named("toStore")
  default Store toStore(StoreEntity store) {
    return new Store(
      store.getId(),
      store.getStoreName(),
      toUserModel(store.getUser()),
      toProductsListFormEntity(store.getProducts()),
      toProductCategoryFormEntity(store.getProductCategories()),
      store.getProductOption().stream().map(e -> new ProductOption()).toList(),
      store.getCreatedAt(),
      store.getUpdatedAt()
    );
  }
  default User toUserModel(UserEntity user){
    return new User();
  }
  default List<Product> toProductsListFormEntity(List<ProductEntity> products) {
    return products.stream().map((product) -> new Product(
        product.getNameTH(),
        product.getNameEN(),
        product.getDescriptionTH(),
        product.getDescriptionEN(),
        product.getPrice(),
        toProductCategoryFormEntity(product.getCategories()),
        toProductImageFormEntity(product.getProductImages()))
        ).toList();
  }

  default List<ProductCategories> toProductCategoryFormEntity(List<ProductCategoriesEntity> categories) {
    return categories.stream().map((category) -> new ProductCategories(category.getName())).toList();
  }

  default List<ProductImage> toProductImageFormEntity(List<ProductImageEntity> productImages) {
    return productImages.stream().map((image) -> new ProductImage(image.getSource())).toList();
  }
}
