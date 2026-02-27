package org.example.springpractice.upload.model;

import lombok.Builder;
import lombok.Getter;

public class UploadDto {

    @Builder
    @Getter
    public static class UploadRes {
        private Long id;
        private String url;

        public static UploadRes fromEntity(Upload entity) {
            return UploadRes.builder()
                    .id(entity.getId())
                    .url(entity.getUrl())
                    .build();
        }
    }
}
