package com.a_peter0.react_tweeter.tweet.api.request;

import com.a_peter0.react_tweeter.base.api.request.BaseRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TweetRequest extends BaseRequest {
    private String content;
    private String nickname;
}
