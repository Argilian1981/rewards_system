package com.myproject.rewards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SubscriberNotFound extends RuntimeException{

    public SubscriberNotFound(String message){
    super(message);
    }
}
