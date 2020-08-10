package com.myproject.rewards.service;

import com.myproject.rewards.model.Subscriber;
import com.myproject.rewards.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriberService {
    @Autowired
    private SubscriberRepository subscriberRepository;

    public Subscriber save(Subscriber subscriber){
        return subscriberRepository.save(subscriber);
    }

    public Subscriber findById(int id){
        Optional<Subscriber> subscriber = subscriberRepository.findById(id);
        return subscriber.get();
    }

    public List<Subscriber> findAll(){
        return subscriberRepository.findAll();
    }

    public void deleteById(int id){
        subscriberRepository.deleteById(id);
    }

}
