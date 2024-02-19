package com.example.demo.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@RestController

public class Controller {

    private UserService user;

    private UserRepo repo;

    @Autowired

    public Controller(UserService user, UserRepo repo) {
        this.user = user;
        this.repo = repo;
    }


    @GetMapping("/welcome")
    public String Welcome(@RequestParam Long msisdn)
    {
        User user =new User(msisdn);
        user.setDate(new Date());
        repo.SaveNewUser(user);
        return "Welcome " + msisdn;

    }


}
