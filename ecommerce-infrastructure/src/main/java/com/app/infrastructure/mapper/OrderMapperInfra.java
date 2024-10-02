package com.app.infrastructure.mapper;

import com.app.domain.models.*;
import com.app.infrastructure.entity.*;
import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface OrderMapperInfra extends GenericMapper<OrderEntity, Order> {
    OrderMapperInfra INSTANT = Mappers.getMapper(OrderMapperInfra.class);

    @Override
    @Mapping(source = "orderItems",target = "orderItems",qualifiedByName = "toOrderItemList")
    Order toModel(OrderEntity order);

    @Override
    @Mapping(target = "orderItems",ignore = true)
    OrderEntity toEntity(Order order);


    @Named("toOrderItemList")
    default Set<OrderItem> toOrderItemList(Set<OrderItemEntity> orderItemList){
        return new HashSet<>(orderItemList.stream().map(this::toOrderItem).toList());
    }

    default OrderItem toOrderItem(OrderItemEntity en){
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(en.getQuantity());
        orderItem.setId(en.getId());
        orderItem.setProduct(addProductToOrderItem(en.getProduct()));
        return orderItem;
    }

    default Product addProductToOrderItem(ProductEntity entity) {
        Product product = new Product();
        product.setId(entity.getId());
        product.setNameTH(entity.getNameTH());
        product.setNameEN(entity.getNameEN());
        product.setDescriptionEN(entity.getDescriptionEN());
        product.setDescriptionTH(entity.getDescriptionTH());
        product.setPrice(entity.getPrice());
        product.setStock(addStockToProduct(entity.getStock()));
        product.setProductImages(addImageListToProduct(entity.getProductImages()));
        product.setProductOptions(addOptionListToProduct(entity.getProductOptions()));
        return product;
    }

    default Stock addStockToProduct(StockEntity stock) {
        return new Stock(stock.getId(), stock.getUnitType(), stock.getUnitQuantity(), stock.getQuantity(),
                stock.getStatus(), stock.isReOrder());
    }

    default Set<ProductImage> addImageListToProduct(Set<ProductImageEntity> et) {
        return new HashSet<>(et.stream().map(e -> addImageToProduct(e)).toList());
    }

    default ProductImage addImageToProduct(ProductImageEntity entity) {
        ProductImage image = new ProductImage(entity.getId(), entity.getSource());
        System.out.println("SOURCE : " + image.getSource());

        return image;
    }

    default Set<ProductOption> addOptionListToProduct(Set<ProductOptionEntity> en) {
        return new HashSet<>(en.stream().map(e -> addOptionToProduct(e)).toList());
    }

    default ProductOption addOptionToProduct(ProductOptionEntity en) {
        return new ProductOption(
                en.getId(),
                en.getOptionName(),
                en.isOneMustBeChosen(),
                en.isManyCanBeChosen(),
                addChoiceListToOption(en.getChoices()),
                en.getLengthSelect(),
                en.getCreatedAt(),
                en.getUpdatedAt());
    }

    default Set<OptionChoice> addChoiceListToOption(Set<OptionChoiceEntity> en) {
        return new HashSet<>(en.stream().map(e -> addChoiceToOption(e)).toList());
    }

    default OptionChoice addChoiceToOption(OptionChoiceEntity en) {
        return new OptionChoice(en.getId(), en.getName(), en.getChoiceEffect(), en.getPrice(), en.getStatus());
    }

}
