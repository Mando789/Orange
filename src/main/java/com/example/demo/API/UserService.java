package com.example.demo.API;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {


    private CrudRepo crudRepo;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(CrudRepo crudRepo) {
        this.crudRepo = crudRepo;

    }

    public boolean IsNew (Long msisdn){
       if(!crudRepo.existsByMsisdn(msisdn)) {  //new user
           CreateUser(msisdn);
           return true;
       } else {
           return false;
       }

    }

    public void CreateUser(Long msisdn){
        Users user = new Users(msisdn);
        user.setMsisdn(msisdn);
        user.setLoginDay(LocalDate.now());

        String[] gifts = {"gift1", "gift2", "gift3"};
        Random random = new Random();
        user.setGift(gifts[random.nextInt(gifts.length)]);

        crudRepo.save(user);
    }

    public Long DaysAgo(Long msisdn){
        LocalDate lastLogin = crudRepo.FindDate(msisdn);
        logger.info(lastLogin.toString());
        return ChronoUnit.DAYS.between(LocalDate.now(), lastLogin);
    }

    public boolean checkFlag(Long msisdn) {
        return crudRepo.checksFlag(msisdn);

    }

    public String getGift(Long msisdn) {
        return crudRepo.getGift(msisdn);
    }

    public void giftRedeemed(Long msisdn)
    {

        Users user = new Users();
        user = crudRepo.findByMsisdn(msisdn);
        user.setFlag(true);
        crudRepo.save(user);


    }
}
