package com.a_peter0.react_tweeter.tweet.controller;

import com.a_peter0.react_tweeter.base.api.response.OkResponse;
import com.a_peter0.react_tweeter.base.controller.BaseController;
import com.a_peter0.react_tweeter.tweet.api.request.TweetRequest;
import com.a_peter0.react_tweeter.tweet.api.request.TweetSearchRequest;
import com.a_peter0.react_tweeter.tweet.api.response.TweetResponse;
import com.a_peter0.react_tweeter.tweet.api.response.TweetSearchResponse;
import com.a_peter0.react_tweeter.tweet.exception.TweetNotExistException;
import com.a_peter0.react_tweeter.tweet.mapping.TweetMapper;
import com.a_peter0.react_tweeter.tweet.routes.TweetApiRoutes;
import com.a_peter0.react_tweeter.tweet.service.TweetService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
class TweetApiController extends BaseController<
        TweetResponse,
        TweetRequest,
        TweetSearchRequest,
        TweetSearchResponse,
        TweetNotExistException
        > {

    private final TweetService service;

    @Override
    @GetMapping(TweetApiRoutes.SEARCH)
    protected OkResponse<TweetSearchResponse> search(@ModelAttribute TweetSearchRequest searchRequest) {
        return OkResponse.of(TweetMapper.getInstance().getFromSearchDocToSearchResponse().convert(service.search(searchRequest)));
    }

    @Override
    @GetMapping(TweetApiRoutes.FIND_BY_ID)
    protected OkResponse<TweetResponse> findById(@PathVariable ObjectId id) throws ChangeSetPersister.NotFoundException {
        return OkResponse.of(TweetMapper.getInstance().getFromDocToResponse().convert(service.findById(id)));
    }

    @Override
    @PostMapping(TweetApiRoutes.POST)
    protected OkResponse<TweetResponse> post(@RequestBody TweetRequest request) {
        return OkResponse.of(TweetMapper.getInstance().getFromDocToResponse().convert(service.create(request)));
    }

    @Override
    @PutMapping(TweetApiRoutes.PUT)
    protected OkResponse<TweetResponse> put(@RequestBody TweetRequest request) throws TweetNotExistException {
        return OkResponse.of(TweetMapper.getInstance().getFromDocToResponse().convert(service.update(request)));
    }

    @Override
    @DeleteMapping(TweetApiRoutes.DELETE)
    protected OkResponse<String> delete(@PathVariable ObjectId id) {
        service.delete(id);
        return OkResponse.of(HttpStatus.OK.toString());
    }

    @PatchMapping(TweetApiRoutes.LIKE)
    private OkResponse<String> like(@PathVariable ObjectId id) throws TweetNotExistException {
        service.like(id);
        return OkResponse.of(HttpStatus.OK.toString());
    }
}
