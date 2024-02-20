package com.example.demo.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class UserService {

    private UserRepo repo;
   // private User user;

    @Autowired
    public UserService(UserRepo repo) {
        this.repo = repo;
        //this.user = user;
    }

    public boolean IsNew (Long msisdn){
       if(!repo.MsisdnExist(msisdn)) //new user
       {
           CreateUser(msisdn);
           return true;
       } else {
           return false;
       }

    }

    public void CreateUser(Long msisdn){
        User user = new User(msisdn);
        user.setMsisdn(msisdn);
        user.setDate(new Date());
        repo.SaveNewUser(user);
    }

    public Long DaysAgo(Long msisdn){
        System.out.println(repo.GetLastLogin(msisdn));

        LocalDate date = repo.GetLastLogin(msisdn).toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();


        return ChronoUnit.DAYS.between(LocalDate.now(), date );
    }

}
