package com.a_peter0.react_tweeter.base.api.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorResponse extends OkResponse<String> {

    private HttpStatus httpStatus;
    private String errorMessage;

    private ErrorResponse(String errorMessage, HttpStatus httpStatus) {
        super(Status.ERROR, null);

        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }

    public static <T> ErrorResponse of(String errorMessage, HttpStatus httpStatus) {
        return new ErrorResponse(errorMessage, httpStatus);
    }
}
