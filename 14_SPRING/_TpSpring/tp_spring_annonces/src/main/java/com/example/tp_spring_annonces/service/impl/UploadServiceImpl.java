package com.example.tp_spring_annonces.service.impl;

import com.example.tp_spring_annonces.service.IUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class UploadServiceImpl implements IUploadService {

    private final String _uploadDir = "src/main/resources/static/uploads";

    public String store(MultipartFile file) throws IOException {
        Path path = Paths.get(_uploadDir);
        String filename = file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();
        Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
        return filename;
    }

    @Override
    public boolean uploadFile(String fileName, byte[] fileContent) {
        return false;
    }
}
