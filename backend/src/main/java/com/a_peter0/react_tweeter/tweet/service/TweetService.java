package com.a_peter0.react_tweeter.tweet.service;

import com.a_peter0.react_tweeter.base.service.BaseService;
import com.a_peter0.react_tweeter.tweet.api.request.TweetRequest;
import com.a_peter0.react_tweeter.tweet.api.request.TweetSearchRequest;
import com.a_peter0.react_tweeter.tweet.exception.TweetNotExistException;
import com.a_peter0.react_tweeter.tweet.model.TweetDoc;
import com.a_peter0.react_tweeter.tweet.model.TweetDocsSearch;
import com.a_peter0.react_tweeter.tweet.repository.TweetRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TweetService extends BaseService<
        TweetDoc,
        TweetRequest,
        TweetDocsSearch,
        TweetSearchRequest,
        TweetNotExistException
        > {

    private final TweetRepository repository;
    private final MongoTemplate mongoTemplate;

    @Override
    public TweetDocsSearch search(TweetSearchRequest request) {

        Criteria criteria = new Criteria();

        if (request.getQuery() != null && !request.getQuery().isEmpty()) {
            criteria = criteria.andOperator(
                    Criteria.where("content").regex(request.getQuery(), "i")
            );
        }

        Query query = new Query(criteria);

        Long count = mongoTemplate.count(query, TweetDoc.class);

        query.limit(request.getSize());
        query.skip(request.getSkip());

        List<TweetDoc> docs = mongoTemplate.find(query, TweetDoc.class);

        return TweetDocsSearch.of(docs, count);
    }

    @Override
    public TweetDoc findById(ObjectId id) throws ChangeSetPersister.NotFoundException {
        Optional<TweetDoc> optionalTweetDoc = repository.findById(id);
        if (optionalTweetDoc.isEmpty())
            throw new ChangeSetPersister.NotFoundException();
        return optionalTweetDoc.get();
    }

    @Override
    public TweetDoc create(TweetRequest request) {
        return repository.save(TweetDoc.builder()
                .numberOfLikes(0)
                .content(request.getContent())
                .nickname(request.getNickname())
                .build());
    }

    @Override
    public TweetDoc update(TweetRequest request) throws TweetNotExistException {
        Optional<TweetDoc> optionalTweetDoc = repository.findById(request.getId());

        if (optionalTweetDoc.isEmpty())
            throw new TweetNotExistException();

        TweetDoc tweetDoc = optionalTweetDoc.get();

        tweetDoc.setContent(request.getContent());
        tweetDoc.setNickname(request.getNickname());

        repository.save(tweetDoc);

        return tweetDoc;
    }

    @Override
    public void delete(ObjectId id) {
        repository.deleteById(id);
    }

    public void like(ObjectId id) throws TweetNotExistException {
        Optional<TweetDoc> optionalTweetDoc = repository.findById(id);
        if (optionalTweetDoc.isEmpty())
            throw new TweetNotExistException();

        TweetDoc tweetDoc = optionalTweetDoc.get();

        tweetDoc.setNumberOfLikes(tweetDoc.getNumberOfLikes() + 1);

        repository.save(tweetDoc);
    }
}
