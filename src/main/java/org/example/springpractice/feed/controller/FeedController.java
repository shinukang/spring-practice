package org.example.springpractice.feed.controller;

import lombok.RequiredArgsConstructor;
import org.example.springpractice.upload.controller.UploadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/feed")
@RequiredArgsConstructor
public class FeedController {
    private final UploadService uploadService;
    private final FeedService feedService;

    @PostMapping("/upload/image")
    public ResponseEntity upload(@RequestParam("images") List<MultipartFile> images) {
        List<String> result = uploadService.upload(images);
        return ResponseEntity.ok(result);
    }
}
