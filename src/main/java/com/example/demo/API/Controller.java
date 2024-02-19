package com.example.demo.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController

public class Controller {

    private UserService user;

    @Autowired
    public Controller(UserService user){
        this.user = user;
    }
    @GetMapping("/welcome")
    public String Welcome(@RequestParam long msisdn)
    {
        long id = user.getId(msisdn);
        return "Welcome " + id;

    }


}
