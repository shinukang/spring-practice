package org.example.springpractice.feed.controller;

import lombok.RequiredArgsConstructor;
import org.example.springpractice.common.model.BaseResponse;
import org.example.springpractice.feed.model.FeedDto;
import org.example.springpractice.upload.controller.UploadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        return ResponseEntity.ok(uploadService.upload(images));
    }

    @PostMapping("/reg")
    public ResponseEntity register(@RequestBody FeedDto.RegisterReq dto) {
        return ResponseEntity.ok(feedService.register(dto));
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return ResponseEntity.ok(BaseResponse.success(feedService.list()));
    }
}
