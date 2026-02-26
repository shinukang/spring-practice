package org.example.springpractice.common.model;

import lombok.Builder;

@Builder
public class BaseResponse<T> {

    private BaseResponseStatus status;
    private T result;

    public static <T> BaseResponse success(T result) {
        return BaseResponse.builder()
                .status(BaseResponseStatus.SUCCESS)
                .result(result)
                .build();
    }

    public static <T> BaseResponse failure(T result, BaseResponseStatus status) {
        return BaseResponse.builder()
                .status(status)
                .result(result)
                .build();
    }

    public static <T> BaseResponse failure(BaseResponseStatus status) {
        return failure(null, status);
    }
}
