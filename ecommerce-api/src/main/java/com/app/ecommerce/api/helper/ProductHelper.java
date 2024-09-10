package com.app.ecommerce.api.helper;

import java.util.List;
import java.util.stream.Collectors;

import com.app.application.dto.CategoriesDTO;
import com.app.application.dto.ProductOptionDTO;
import com.app.application.dto.ProductsDTO;
import com.app.ecommerce.api.request.ProductFormData;
import com.app.ecommerce.api.request.ProductRequest;

public class ProductHelper {
    
    public static ProductsDTO convertoTProductsDTO(ProductRequest productRequest) {
        ProductFormData productFormData = productRequest.getProducts();

        ProductsDTO productsDTO = new ProductsDTO();
        productsDTO.setNameTH(productFormData.getNameTH());
        productsDTO.setNameEN(productFormData.getNameEN());
        productsDTO.setDescriptionTH(productFormData.getDescriptionTH());
        productsDTO.setDescriptionEN(productFormData.getDescriptionEN());
        productsDTO.setPrice(productFormData.getPrice());
        productsDTO.setQuantity(productFormData.getQuantity());
        productsDTO.setStock(productFormData.getStock());

        // Convert categories (assuming there's a conversion needed, adjust as needed)
        List<CategoriesDTO> categoriesDTOs = productFormData.getCategories().stream()
                .map(category -> new CategoriesDTO(category)) // Assuming CategoriesDTO has a constructor accepting a string
                .collect(Collectors.toList());
        productsDTO.setCategories(categoriesDTOs);

        // Convert product options (assuming there's a conversion needed, adjust as needed)
        List<ProductOptionDTO> productOptionDTOs = productFormData.getProductOptions().stream()
                .map(option -> new ProductOptionDTO(option)) // Assuming ProductOptionDTO has a constructor accepting a string
                .collect(Collectors.toList());
        productsDTO.setProductOptions(productOptionDTOs);

        return productsDTO;
    }
}
