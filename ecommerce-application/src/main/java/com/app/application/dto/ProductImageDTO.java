package com.app.application.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProductImageDTO{
    private MultipartFile source;

    public MultipartFile getSource() {
        return source;
    }

    public void setSource(MultipartFile source) {
        this.source = source;
    }

    public ProductImageDTO(MultipartFile source) {
        this.source = source;
    }
    

    
}
