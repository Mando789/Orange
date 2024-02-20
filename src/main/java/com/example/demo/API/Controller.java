package com.example.demo.API;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController

public class Controller {

    private UserService userService;
    //private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired

    public Controller(UserService userService) {
        this.userService = userService;

    }


    @GetMapping("/welcome")
    public String Welcome(@RequestParam Long msisdn)
    {
        if (userService.IsNew(msisdn))
        {
            return "Welcome";
        } else {

            Long days = userService.DaysAgo(msisdn);

           return "Welcome again \n\n" + "Last login was " + days + " days ago" ;
        }


    }
    @GetMapping("/gift")
    public String Gift(@RequestParam Long msisdn)
    {
        if (!userService.checkFlag(msisdn))
        {
            String gift = userService.getGift(msisdn);
            return "Redeem your gift now " + gift + " ," + msisdn;

        } else {
            return "Gift already redeemed";
        }
    }

    @GetMapping("/redeem")
    public String Redeem(@RequestParam Long msisdn)
    {
        if (!userService.checkFlag(msisdn))
        {

            String gift = userService.getGift(msisdn);
            userService.giftRedeemed(msisdn);
            return "Here is your gift " + gift;

        } else {
            return "Gift already redeemed";
        }
    }


}
