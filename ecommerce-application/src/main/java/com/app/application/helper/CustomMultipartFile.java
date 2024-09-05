package com.app.application.helper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import org.springframework.web.multipart.MultipartFile;
public class CustomMultipartFile implements MultipartFile {

    private byte[] content;
    private String name;
    private String originalFilename;
    private String contentType;

    
    public CustomMultipartFile(byte[] content, String name, String originalFilename, String contentType) {
        this.content = content;
        this.name = name;
        this.originalFilename = originalFilename;
        this.contentType = contentType;
    }

    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getOriginalFilename() {
        return originalFilename;
    }

    @Override
    public String getContentType() {
        return contentType;
    }

    @Override
    public boolean isEmpty() {
        return content.length == 0;
    }

    @Override
    public long getSize() {
        return content.length;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return content;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(content);
    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {
        try (FileOutputStream fos = new FileOutputStream(dest)) {
            fos.write(content);
        }
    }


    public byte[] getContent() {
        return content;
    }


    public void setContent(byte[] content) {
        this.content = content;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setContentType(String contentType) {
        this.contentType = contentType;
    }


    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    
    
}
