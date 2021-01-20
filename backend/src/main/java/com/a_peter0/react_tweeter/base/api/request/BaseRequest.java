package com.a_peter0.react_tweeter.base.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
public class BaseRequest {
    protected ObjectId id;
}
