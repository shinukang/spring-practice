package org.example.springpractice.feed.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.example.springpractice.upload.model.Upload;

import java.util.ArrayList;
import java.util.List;

public class FeedDto {

    @Getter
    @AllArgsConstructor
    @Builder
    public static class RegisterReq {
        private String contents;
        List<Long> imageIdxList;

        public Feed toEntity() {
            return Feed.builder()
                    .contents(contents)
                    .images(new ArrayList<>())
                    .build();
        }
    }

    @Getter
    @AllArgsConstructor
    public static class RegisterRes {

    }

    @Getter
    @AllArgsConstructor
    @Builder
    public static class PostRes {
        private String contents;
        private List<String> images;

        public static PostRes fromEntity(Feed entity) {
            return PostRes.builder()
                    .contents(entity.getContents())
                    .images(entity.getImages().stream().map(
                            Upload::getUrl
                    ).toList())
                    .build();
        }
    }
}
