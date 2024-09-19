package com.app.application.helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.app.infrastructure.exception.BaseException;

@Component
public class FileManagement {
    @Value("${mount-path}")
    private String mountPath;

    public String createPathFile(MultipartFile multipartFile, String id) throws IOException {
        // กำหนดชื่อไฟล์และตำแหน่งในการบันทึก
        Path destination = Paths.get(mountPath + "images/" + id, multipartFile.getOriginalFilename());

        // สร้างไดเรกทอรีถ้ายังไม่มีอยู่
        if (Files.notExists(destination.getParent())) {
            Files.createDirectories(destination.getParent());
        }

        if (!destination.toFile().exists()) {
            boolean createFile = destination.toFile().createNewFile();
            if (createFile) {
                System.out.println("File has created");
            }
        }
        Files.write(destination, multipartFile.getBytes());
        return String.format("images/%s/%s", id, multipartFile.getOriginalFilename());
    }

    public void removeFile(String path) {
        Path destination = Paths.get(mountPath, path);
        System.out.println(String.format("FILE IS : %s", destination.toAbsolutePath()));

        if (Files.notExists(destination)) {
            throw new BaseException("File not found!!");
        }
        try {
            Files.delete(destination);
        } catch (IOException e) {
            throw new BaseException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
