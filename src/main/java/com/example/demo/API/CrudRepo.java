package com.example.demo.API;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Optional;


public interface CrudRepo extends CrudRepository<Users, Long> {

    @Query ("SELECT LOGIN_DAY FROM Users WHERE Msisdn = :msisdn")
    LocalDate FindDate(Long msisdn);



    Boolean existsByMsisdn(Long msisdn);

    Users findByMsisdn(Long msisdn);

    @Query ("SELECT EXISTS (SELECT 1 FROM Users WHERE MSISDN = :msisdn AND FLAG = TRUE) ")
    Boolean checksFlag(Long msisdn);

    @Query ("SELECT GIFT FROM USERS WHERE MSISDN = :msisdn")
    String getGift(Long msisdn);



}
