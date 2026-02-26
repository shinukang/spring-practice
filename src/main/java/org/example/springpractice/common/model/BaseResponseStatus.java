package org.example.springpractice.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BaseResponseStatus {

    SUCCESS(true, 1000, "성공"),
    FAILURE(false, 4000, "실패");

    private boolean success;
    private int code;
    private String message;
}
