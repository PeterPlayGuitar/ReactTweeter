package com.a_peter0.react_tweeter.tweet.model;

import com.a_peter0.react_tweeter.base.api.response.BaseSearchResponse;
import lombok.Builder;

import java.util.List;

public class TweetDocsSearch extends BaseSearchResponse<TweetDoc> {
    protected TweetDocsSearch(List<TweetDoc> items, Long size) {
        super(items, size);
    }

    public static TweetDocsSearch of(List<TweetDoc> items, Long size) {
        return new TweetDocsSearch(items, size);
    }
}
