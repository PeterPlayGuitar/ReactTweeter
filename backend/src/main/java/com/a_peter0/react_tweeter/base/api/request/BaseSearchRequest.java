package com.a_peter0.react_tweeter.base.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseSearchRequest {
    protected String query;
    protected Integer size = 20;
    protected Integer skip = 0;
}
