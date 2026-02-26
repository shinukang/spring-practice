package org.example.springpractice.feed.model;

import java.util.List;

public class FeedDto {

    public static class RegisterReq {
        private String contents;
        List<Long> imageIdxList;
    }
}
