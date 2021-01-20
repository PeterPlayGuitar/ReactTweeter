package com.a_peter0.react_tweeter.tweet.mapping;

import com.a_peter0.react_tweeter.base.mapping.BaseMapper;
import com.a_peter0.react_tweeter.tweet.api.response.TweetResponse;
import com.a_peter0.react_tweeter.tweet.api.response.TweetSearchResponse;
import com.a_peter0.react_tweeter.tweet.model.TweetDoc;
import com.a_peter0.react_tweeter.tweet.model.TweetDocsSearch;
import lombok.Getter;

import java.util.stream.Collectors;

@Getter
public class TweetMapper {

    public static class FromDocToResponse extends BaseMapper<TweetDoc, TweetResponse> {

        @Override
        public TweetResponse convert(TweetDoc tweetDoc) {
            return TweetResponse.builder()
                    .content(tweetDoc.getContent())
                    .nickname(tweetDoc.getNickname())
                    .numberOfLikes(tweetDoc.getNumberOfLikes())
                    .id(tweetDoc.getId().toString())
                    .build();

        }
    }

    public static class FromSearchDocToSearchResponse extends BaseMapper<TweetDocsSearch, TweetSearchResponse> {

        @Override
        public TweetSearchResponse convert(TweetDocsSearch tweetDocsSearch) {
            var converter = new FromDocToResponse();
            return TweetSearchResponse.of(
                    tweetDocsSearch.getItems().stream().map(converter::convert).collect(Collectors.toList()),
                    tweetDocsSearch.getSize());
        }
    }

    private FromDocToResponse fromDocToResponse = new FromDocToResponse();
    private FromSearchDocToSearchResponse fromSearchDocToSearchResponse = new FromSearchDocToSearchResponse();

    private static TweetMapper tweetMapper = null;

    public static TweetMapper getInstance() {
        if (tweetMapper == null)
            tweetMapper = new TweetMapper();
        return tweetMapper;
    }
}
