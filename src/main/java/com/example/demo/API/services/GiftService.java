package com.example.demo.API.services;

import com.example.demo.API.model.Gift;
import com.example.demo.API.repository.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GiftService {

    private final GiftRepository giftRepo;

    @Autowired
    public GiftService(GiftRepository giftRepo) {
        this.giftRepo = giftRepo;
    }


    public Optional<Gift> getGift(Integer giftId) {

        return giftRepo.findById(giftId);
    }
}
