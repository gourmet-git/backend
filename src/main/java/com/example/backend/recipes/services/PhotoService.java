package com.example.backend.recipes.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PhotoService {

    String save(MultipartFile multipartFile, String directoryPath)  throws IOException;
}
