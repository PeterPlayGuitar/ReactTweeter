package com.a_peter0.react_tweeter.base.controller;

import com.a_peter0.react_tweeter.base.api.request.BaseRequest;
import com.a_peter0.react_tweeter.base.api.request.BaseSearchRequest;
import com.a_peter0.react_tweeter.base.api.response.BaseResponse;
import com.a_peter0.react_tweeter.base.api.response.BaseSearchResponse;
import com.a_peter0.react_tweeter.base.api.response.OkResponse;
import com.a_peter0.react_tweeter.base.exception.BaseException;
import com.a_peter0.react_tweeter.base.routes.BaseApiRoutes;
import com.a_peter0.react_tweeter.base.service.BaseService;
import com.a_peter0.react_tweeter.tweet.exception.TweetNotExistException;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

@Setter
public abstract class BaseController<
        ResponseType extends BaseResponse,
        RequestType extends BaseRequest,
        SearchRequestType extends BaseSearchRequest,
        SearchResponseType extends BaseSearchResponse<ResponseType>,
        NotExistExceptionType extends BaseException
        > {

    protected abstract OkResponse<SearchResponseType> search(@ModelAttribute SearchRequestType searchRequest);

    protected abstract OkResponse<ResponseType> findById(@PathVariable ObjectId id) throws ChangeSetPersister.NotFoundException;

    protected abstract OkResponse<ResponseType> post(@RequestBody RequestType request);

    protected abstract OkResponse<ResponseType> put(@RequestBody RequestType request) throws NotExistExceptionType;

    protected abstract OkResponse<String> delete(@PathVariable ObjectId id);
}
