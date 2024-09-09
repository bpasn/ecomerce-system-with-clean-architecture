package com.app.application.helper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;


@Service
public class Utils {

    @Value("${mount-path}")
    private String mountPath;
    public String createPathFile(MultipartFile multipartFile, String id) throws IOException {
        String pathFile = String.format("images/%s/%s", id, multipartFile.getOriginalFilename());

        // กำหนดชื่อไฟล์และตำแหน่งในการบันทึก
        Path destination = Paths.get(mountPath + pathFile);

        // สร้างไดเรกทอรีถ้ายังไม่มีอยู่
        if (Files.notExists(destination.getParent())) {
            Files.createDirectories(destination.getParent());
        }

        if (!destination.toFile().exists()) {
            destination.toFile().createNewFile();
        }
        Files.write(destination, multipartFile.getBytes());
        return pathFile;
    }
}
