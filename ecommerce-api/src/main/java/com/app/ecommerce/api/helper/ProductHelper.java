package com.app.ecommerce.api.helper;

import java.util.List;
import java.util.stream.Collectors;

import com.app.application.dto.CategoriesDTO;
import com.app.application.dto.ProductOptionDTO;
import com.app.application.dto.ProductsDTO;
import com.app.ecommerce.api.request.ProductFormData;
import com.app.ecommerce.api.request.ProductRequest;

public class ProductHelper {

    ProductHelper() {
    }

    public static ProductsDTO convertoTProductsDTO(ProductRequest productRequest) {
        ProductFormData productFormData = productRequest.getProducts();

        ProductsDTO productsDTO = new ProductsDTO();
        productsDTO.setNameTH(productFormData.getNameTH());
        productsDTO.setNameEN(productFormData.getNameEN());
        productsDTO.setDescriptionTH(productFormData.getDescriptionTH());
        productsDTO.setDescriptionEN(productFormData.getDescriptionEN());
        productsDTO.setPrice(productFormData.getPrice());
        productsDTO.setStock(productFormData.getStock());
        productsDTO.setStoreId(productFormData.getStoreId());
        
        if (!productFormData.getCategories().isEmpty()) {
            List<CategoriesDTO> categoriesDTOs = productFormData.getCategories().stream()
                    .map(category -> new CategoriesDTO(category))
                    .collect(Collectors.toList());
            productsDTO.setCategories(categoriesDTOs);
        }
        if (!productFormData.getProductOptions().isEmpty()) {
            List<ProductOptionDTO> productOptionDTOs = productFormData.getProductOptions().stream()
                    .map(option -> new ProductOptionDTO(option))
                    .collect(Collectors.toList());
            productsDTO.setProductOptions(productOptionDTOs);
        }

        return productsDTO;
    }
}
