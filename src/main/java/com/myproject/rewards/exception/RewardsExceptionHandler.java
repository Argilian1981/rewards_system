package com.myproject.rewards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class RewardsExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex , WebRequest request){
        RewardsExceptionResponse rewardsExceptionResponse = new RewardsExceptionResponse(new Date() , ex.getMessage() ,
                request.getDescription(false));

        return new ResponseEntity(rewardsExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SubscriberNotFound.class)
    public final ResponseEntity<Object> handleSubscriberNotFoundException(SubscriberNotFound ex, WebRequest request){

        RewardsExceptionResponse rewardsExceptionResponse = new RewardsExceptionResponse(new Date() , ex.getMessage() ,
                request.getDescription(false));

        return new ResponseEntity(rewardsExceptionResponse, HttpStatus.NOT_FOUND);
    }
}
