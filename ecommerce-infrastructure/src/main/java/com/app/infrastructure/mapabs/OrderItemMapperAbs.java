package com.app.infrastructure.mapabs;

import com.app.domain.models.OrderItem;
import com.app.domain.models.OrderItemOption;
import com.app.domain.models.Product;
import com.app.domain.models.ProductImage;
import com.app.infrastructure.entity.OrderItemEntity;
import com.app.infrastructure.entity.OrderItemOptionEntity;
import com.app.infrastructure.entity.ProductEntity;
import com.app.infrastructure.entity.ProductImageEntity;
import com.app.infrastructure.mapper.OrderItemMapperInfra;
import com.app.infrastructure.mapper.OrderItemOptionMapperInfra;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//@Mapper(componentModel = "spring",uses = {OrderItemOptionMapperInfra.class})
public abstract class OrderItemMapperAbs implements OrderItemMapperInfra {

//    @Autowired
//    protected  OrderItemOptionMapperInfra orderItemOptionMapperInfra;
//    @Autowired
//
//    @Override
//    @Mapping(target="order.orderItems",ignore = true)
//    @Mapping(target ="orderItemOptions",expression = "java(order.getOrderItemOptions().stream().map(orderItemOptionMapperInfra::toEntity).toList())")
//    public abstract OrderItemEntity toEntity(OrderItem order);
//
//    @Override
//    @Mapping(target="order.orderItems",ignore = true)
//
//    @Mapping(target="product.productOptions" , ignore = true)
//    @Mapping(target="product.categories" , ignore = true)
//    @Mapping(target="product.stock" , ignore = true)
//    @Mapping(target="product.store" , ignore = true)
//    @Mapping(target="product.productImages" , source = "product.productImages",qualifiedByName = "toProductImageList")
//    @Mapping(target ="orderItemOptions", expression = "java(toOrderItemOption(order.getOrderItemOptions()))")
//    public abstract OrderItem toModel(OrderItemEntity order);
//
//    @Named("toProductImageList")
//    public  Set<ProductImage> toProductImageList(Set<ProductImageEntity> en){
//        return en.stream().map(e -> new ProductImage(e.getId(),e.getSource())).collect(Collectors.toSet());
//    }
//
//    public List<OrderItemOption> toOrderItemOption(List<OrderItemOptionEntity> orderItemOptions){
//        System.out.println("TO ORDER ITEM OPTIONS");
//        return orderItemOptions.stream().map(orderItemOptionMapperInfra::toModel).collect(Collectors.toList());
//    }
//    public Product toProduct(ProductEntity product){
//        return new Product(
//                product.getNameTH(),
//                product.getNameEN(),
//                product.getDescriptionTH(),
//                product.getDescriptionEN(),
//                product.getPrice(),
//                product.getProductImages().stream().map(e -> new ProductImage(e.getId(),e.getSource())).collect(Collectors.toSet())
//        );
//    }
}
