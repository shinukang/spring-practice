package org.example.springpractice.common.exception;

import org.example.springpractice.common.model.BaseResponse;
import org.example.springpractice.common.model.BaseResponseStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity handleException(BaseException e) {
        BaseResponseStatus staus = e.getStatus();
        int code = staus.getCode();
        BaseResponse response = BaseResponse.failure(staus);
        return ResponseEntity.status(statusCodeMapper(code)).body(response);
    }

    private int statusCodeMapper(int errorCode) {
        return switch (errorCode % 1000) {
            case 5 -> 500;
            default -> 400;
        };
    }
}
