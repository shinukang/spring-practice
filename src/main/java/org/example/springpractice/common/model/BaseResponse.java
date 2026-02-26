package org.example.springpractice.common.model;

import lombok.Builder;
import org.springframework.http.ResponseEntity;

@Builder
public class BaseResponse<T> {

    private BaseResponseStatus status;
    private T result;

    public static <T> ResponseEntity success(T result) {
        return ResponseEntity.ok(BaseResponse.builder()
                .status(BaseResponseStatus.SUCCESS)
                .result(result)
                .build());
    }

    public static <T> ResponseEntity failure(BaseResponseStatus status) {
        return failure(null, status);
    }

    public static <T> ResponseEntity failure(T result, BaseResponseStatus status) {
        return ResponseEntity.ok(BaseResponse.builder()
                .status(status)
                .result(result)
                .build());
    }
}
