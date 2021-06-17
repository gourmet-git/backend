package com.example.backend.recipes.services;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Override
    public String save(MultipartFile multipartFile,String directoryPath) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        Path uploadPath = Paths.get(directoryPath);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }

        return String.format("%s/%s", directoryPath, fileName);
    }
}
