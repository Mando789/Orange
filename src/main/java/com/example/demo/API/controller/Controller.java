package com.example.demo.API.controller;

import com.example.demo.API.model.Gift;
import com.example.demo.API.services.CounterService;
import com.example.demo.API.services.DialsService;
import com.example.demo.API.services.GiftService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@RestController

public class Controller {

    DialsService dialsService;
    CounterService counterService;

    GiftService giftService;
   // private final Logger logger = LoggerFactory.getLogger(UserService.class);


    @Autowired
    public Controller(DialsService dialsService, CounterService counterService, GiftService giftService) {
        this.dialsService = dialsService;
        this.counterService = counterService;
        this.giftService = giftService;
    }


    @GetMapping("/welcome")
    public String Welcome(@RequestParam Long msisdn)
    {

        if (dialsService.IsNew(msisdn))
        {
            return "Welcome";
        } else {

            return "Welcome again";
        }

    }
    @GetMapping("/gift")
    public String Gift(@RequestParam Long msisdn)
    {

        if (!dialsService.hasGroup(msisdn) || !dialsService.hasGift(msisdn) || !counterService.canRedeem(msisdn)) {
            return "No gift";
        }

        Integer giftId = counterService.getGiftId(msisdn);
        Optional<Gift> gift = giftService.getGift(giftId);
        return "Gift Id and Name \n" + gift.toString();


    }

    @GetMapping("/redeem")
    public String Redeem(@RequestParam Long msisdn, @RequestParam Integer id)
    {

        if (!dialsService.sameGift(msisdn,id))
        {
            return "Gift id does not match your group";
        }

        Optional<Gift> giftOpt = giftService.getGift(id);
        if (giftOpt.isPresent())
        {
            Gift gift = giftOpt.get();
            counterService.increment(msisdn);
            return "Here is your Gift!! \n " + gift.getName();
        }

        return "No gift";

    }




}