package com.a_peter0.react_tweeter.base.service;

import com.a_peter0.react_tweeter.base.api.request.BaseRequest;
import com.a_peter0.react_tweeter.base.api.request.BaseSearchRequest;
import com.a_peter0.react_tweeter.base.api.response.BaseSearchResponse;
import com.a_peter0.react_tweeter.base.exception.BaseException;
import com.a_peter0.react_tweeter.base.model.BaseDoc;
import com.a_peter0.react_tweeter.tweet.exception.TweetNotExistException;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.mongodb.core.MongoTemplate;

public abstract class BaseService<
        DocType extends BaseDoc,
        RequestType extends BaseRequest,
        SearchResponseType extends BaseSearchResponse<DocType>,
        SearchRequestType extends BaseSearchRequest,
        NotExistException extends BaseException
        > {

    public abstract SearchResponseType search(SearchRequestType request);

    public abstract DocType findById(ObjectId id) throws ChangeSetPersister.NotFoundException;

    public abstract DocType create(RequestType request);

    public abstract DocType update(RequestType request) throws NotExistException;

    public abstract void delete(ObjectId id);
}
