package com.example.demo.API.services;

import com.example.demo.API.model.Counter;
import com.example.demo.API.repository.CounterRepository;
import com.example.demo.API.repository.DialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CounterService {

    private CounterRepository counterRepo;

    @Autowired
    public CounterService(CounterRepository counterRepo) {
        this.counterRepo = counterRepo;
    }

    public boolean canRedeem(Long msisdn) {
        Optional<Counter> userOpt= counterRepo.findByMsisdn(msisdn);
        if (userOpt.isPresent()){
            Counter user= userOpt.get();
            return user.getCounter() <= 2;
        }

        return false;

    }

    public Integer getGiftId(Long msisdn) {
        Optional<Counter> userOpt= counterRepo.findByMsisdn(msisdn);
        if(userOpt.isPresent()){
            Counter user= userOpt.get();
            return user.getGiftId();
        }
        return 0;
    }

    public void increment(Long msisdn) {

        Optional<Counter> userOpt= counterRepo.findByMsisdn(msisdn);
        if(userOpt.isPresent()){
            Counter user= userOpt.get();
            user.setCounter(user.getCounter() + 1);
            counterRepo.save(user);
        }

    }
}
