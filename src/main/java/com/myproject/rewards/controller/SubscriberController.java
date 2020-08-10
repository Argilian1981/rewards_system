package com.myproject.rewards.controller;

import com.myproject.rewards.exception.SubscriberNotFound;
import com.myproject.rewards.model.Subscriber;
import com.myproject.rewards.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class SubscriberController {
    @Autowired
    private SubscriberService subscriberService;

    @PostMapping(path = "/subscribers")
    public ResponseEntity<Object> saveSubscriber(@RequestBody Subscriber subscriber){
        Subscriber savedSubscriber = subscriberService.save(subscriber);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedSubscriber.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping(path = "/subscribers")
    public List<Subscriber> findAllSubscribers(){
        return subscriberService.findAll();
    }

    @GetMapping(path = "/subscribers/{id}")
    public Subscriber findSubscriberById(@PathVariable int id){
        Subscriber subscriber = subscriberService.findById(id);
        if(subscriber == null){
            throw new SubscriberNotFound("id = " + id);
        }

        return subscriber;
    }

    @DeleteMapping(path = "/subscribers/{id}")
    public void deleteSubscriber(@PathVariable int id){
        subscriberService.deleteById(id);
    }


}
