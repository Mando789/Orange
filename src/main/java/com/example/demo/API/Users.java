package com.example.demo.API;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class Users {


    @Id
    private int id;
    private Long msisdn;
    private LocalDate loginDay;

    private String gift;

    private boolean flag;

    public Users() {
    }

    public Users(int id, Long msisdn, LocalDate loginDay, String gift, boolean flag) {
        this.id = id;
        this.msisdn = msisdn;
        this.loginDay = loginDay;
        this.gift = gift;
        this.flag = flag;
    }

    public Users(Long msisdn) {
        this.msisdn = msisdn;
    }

    public Long getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(Long msisdn) {
        this.msisdn = msisdn;
    }

    public void setLoginDay(LocalDate loginDay) {
        this.loginDay = loginDay;
    }
    public LocalDate getLoginDay() {
        return loginDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", msisdn=" + msisdn +
                ", loginDay=" + loginDay +
                ", gift='" + gift + '\'' +
                ", flag=" + flag +
                '}';
    }
}

