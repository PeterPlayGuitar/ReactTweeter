package com.a_peter0.react_tweeter.base.controller;

import com.a_peter0.react_tweeter.base.api.response.ErrorResponse;
import com.a_peter0.react_tweeter.tweet.exception.TweetNotExistException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class HandleApiExceptions {

    private ResponseEntity<Object> buildResponseEntity(ErrorResponse response) {
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @ExceptionHandler(TweetNotExistException.class)
    public ResponseEntity<Object> TweetNotExistException(TweetNotExistException ex, WebRequest request) {
        return buildResponseEntity(ErrorResponse.of("This tweet does not exists", HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<Object> NotFoundException(ChangeSetPersister.NotFoundException ex, WebRequest request) {
        return buildResponseEntity(ErrorResponse.of("Can't find the entity", HttpStatus.BAD_REQUEST));
    }
}
