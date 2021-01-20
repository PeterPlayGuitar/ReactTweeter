package com.a_peter0.react_tweeter.tweet.api.response;

import com.a_peter0.react_tweeter.base.api.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Builder
@Setter
@Getter
public class TweetResponse extends BaseResponse {
    private String id;
    private String nickname;
    private String content;
    private Integer numberOfLikes;
}
