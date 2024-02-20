package com.example.demo.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController

public class Controller {

    private UserService userService;

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


}
