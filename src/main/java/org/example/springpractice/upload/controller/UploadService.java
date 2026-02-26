package org.example.springpractice.upload.controller;

import io.awspring.cloud.s3.S3Operations;
import io.awspring.cloud.s3.S3Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UploadService {
    @Value("${spring.cloud.aws.s3.bucket}")
    private String s3BucketName;
    private final S3Operations s3Operations;

    private String saveFile(MultipartFile file) throws IOException {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        String filePath = date + "/" + UUID.randomUUID() + "_" + file.getOriginalFilename();
        S3Resource s3Resource = s3Operations.upload(s3BucketName, filePath, file.getInputStream());
        return s3Resource.getURL().toString();
    }

    public List<String> upload(List<MultipartFile> files) {
        List<String> uploadPaths = new ArrayList<>();
        try {
            for (MultipartFile file : files) {
                uploadPaths.add(saveFile(file));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return uploadPaths;
    }
}
