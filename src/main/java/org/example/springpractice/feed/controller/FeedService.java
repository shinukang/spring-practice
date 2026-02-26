package org.example.springpractice.feed.controller;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.springpractice.feed.model.Feed;
import org.example.springpractice.feed.model.FeedDto;
import org.example.springpractice.upload.controller.UploadRepository;
import org.example.springpractice.upload.model.Upload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedRepository feedRepository;
    private final UploadRepository uploadRepository;

    @Transactional
    public FeedDto.RegisterRes register(FeedDto.RegisterReq dto) {
        Feed feed = feedRepository.save(dto.toEntity());

        for (Upload image : uploadRepository.findAllById(dto.getImageIdxList())) {
            feed.addImage(image);
        }
        return new FeedDto.RegisterRes();
    }

    public List<FeedDto.PostRes> list() {
        return feedRepository.findAll().stream().map(FeedDto.PostRes::fromEntity).toList();
    }
}
