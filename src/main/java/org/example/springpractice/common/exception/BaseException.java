package org.example.springpractice.common.exception;

import lombok.Getter;
import org.example.springpractice.common.model.BaseResponseStatus;

@Getter
public class BaseException extends RuntimeException {
    private BaseResponseStatus status;

    private BaseException(BaseResponseStatus status) {
        super(status.getMessage());
        this.status = status;
    }

    public static BaseException from(BaseResponseStatus status) {
        return new BaseException(status);
    }
}
