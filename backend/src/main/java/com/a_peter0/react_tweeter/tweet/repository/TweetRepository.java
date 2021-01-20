package com.a_peter0.react_tweeter.tweet.repository;

import com.a_peter0.react_tweeter.tweet.model.TweetDoc;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends MongoRepository<TweetDoc, ObjectId> {
}
