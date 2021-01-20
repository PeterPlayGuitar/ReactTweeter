package com.a_peter0.react_tweeter.base.mapping;

import com.a_peter0.react_tweeter.base.api.request.BaseRequest;
import com.a_peter0.react_tweeter.base.model.BaseDoc;

public abstract class BaseMapper<From, To> {
    public abstract To convert (From from);
}
