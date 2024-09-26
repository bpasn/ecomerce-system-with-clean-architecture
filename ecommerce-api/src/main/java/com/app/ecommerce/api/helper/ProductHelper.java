package com.app.ecommerce.api.helper;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import com.app.application.dto.CategoriesDTO;
import com.app.application.dto.ProductOptionDTO;
import com.app.application.dto.ProductsDTO;
import com.app.ecommerce.api.request.product.ProductFormData;
import com.app.ecommerce.api.request.product.ProductRequest;

public class ProductHelper {

    ProductHelper() {
    }

    public static ProductsDTO convertoTProductsDTO(ProductRequest productRequest) {
        ProductFormData productFormData = productRequest.getProduct();

        ProductsDTO productsDTO = new ProductsDTO();
        productsDTO.setNameTH(productFormData.getNameTH());
        productsDTO.setNameEN(productFormData.getNameEN());
        productsDTO.setDescriptionTH(productFormData.getDescriptionTH());
        productsDTO.setDescriptionEN(productFormData.getDescriptionEN());
        productsDTO.setPrice(new BigDecimal(productFormData.getPrice()));
        productsDTO.setStock(productRequest.getStock());
        productsDTO.setStoreId(productFormData.getStoreId());
        if (productRequest.getCategories() != null) {
            List<CategoriesDTO> categoriesDTOs = productRequest.getCategories().stream()
                    .map(category -> new CategoriesDTO(category))
                    .collect(Collectors.toList());
            productsDTO.setCategories(new HashSet<>(categoriesDTOs));
        }else {
            productsDTO.setCategories(new HashSet<>());
        }
        if (productRequest.getProductOptions() != null) {
            List<ProductOptionDTO> productOptionDTOs = productRequest.getProductOptions().stream()
                    .map(option -> new ProductOptionDTO(option))
                    .collect(Collectors.toList());
            productsDTO.setProductOptions(new HashSet<>(productOptionDTOs));
        }else{
            productsDTO.setProductOptions(new HashSet<>());
        }

        System.out.println("productsDTO");
        return productsDTO;
    }
}
