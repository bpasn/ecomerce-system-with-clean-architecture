package com.app.ecommerce.api.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;
import java.io.File;
@RestController
@RequestMapping("${api.prefix.route}/file")
public class FileController {
    @Value("${mount-path}")
     private String BASE_DIR; // กำหนด base directory ที่เก็บไฟล์จริง

    @GetMapping("/filepath/{uuid}/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String uuid, @PathVariable String filename) {
        System.out.println(uuid);
        System.out.println(filename);
        try {
            // สร้าง path จริงจาก UUID และ filename ที่รับมา
            String filePath = String.format("%s/%s/%s", BASE_DIR, uuid, filename);
            File file = new File(filePath);
            if (!file.exists()) {
                return ResponseEntity.notFound().build();
            }

            Resource resource = new FileSystemResource(file);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, "application/octet-stream"); // กำหนดประเภทไฟล์ที่เหมาะสม
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + file.getName());

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
