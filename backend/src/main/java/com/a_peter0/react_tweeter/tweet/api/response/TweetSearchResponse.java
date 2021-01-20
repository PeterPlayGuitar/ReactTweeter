package com.a_peter0.react_tweeter.tweet.api.response;

import com.a_peter0.react_tweeter.base.api.response.BaseSearchResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class TweetSearchResponse extends BaseSearchResponse<TweetResponse> {

    protected TweetSearchResponse(List<TweetResponse> items, Long size) {
        super(items, size);
    }

    public static TweetSearchResponse of(List<TweetResponse> items, Long size) {
        return new TweetSearchResponse(items, size);
    }
}
