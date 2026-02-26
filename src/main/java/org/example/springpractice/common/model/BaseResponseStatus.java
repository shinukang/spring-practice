package org.example.springpractice.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BaseResponseStatus {

    SUCCESS(true, 1000, "성공"),

    // 클라이언트 사이드 이슈: 2000~
    DUPLICATED_EMAIL(false, 2000, "중복된 이메일입니다."),
    INVALID_INPUT(false, 2001, "유효하지 않은 이메일 혹은 비밀번호입니다."),
    FAILURE(false, 4000, "실패");

    private boolean success;
    private int code;
    private String message;
}
