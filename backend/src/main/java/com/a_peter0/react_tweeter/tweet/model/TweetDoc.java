package com.a_peter0.react_tweeter.tweet.model;

import com.a_peter0.react_tweeter.base.model.BaseDoc;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@Builder
public class TweetDoc extends BaseDoc {

    @Id
    private ObjectId id;
    private String nickname;
    private String content;
    private Integer numberOfLikes;

}
