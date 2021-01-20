package com.a_peter0.react_tweeter.base.api.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class BaseSearchResponse<ResponseType> {

    protected Long size;
    protected List<ResponseType> items;

    protected BaseSearchResponse(List<ResponseType> items, Long size) {
        this.items = items;
        this.size = size;
    }
}
