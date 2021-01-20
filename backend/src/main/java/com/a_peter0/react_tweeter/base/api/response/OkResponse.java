package com.a_peter0.react_tweeter.base.api.response;

import lombok.Getter;

@Getter
public class OkResponse<ResponseEntityType> {

    public enum Status {
        SUCCESS,
        ERROR
    }

    protected OkResponse(Status status, ResponseEntityType content) {
        this.status = status;
        this.content = content;
    }

    protected Status status;
    protected ResponseEntityType content;

    public static <ResponseEntityType> OkResponse of(ResponseEntityType content) {
        return new OkResponse(Status.SUCCESS, content);
    }
}
