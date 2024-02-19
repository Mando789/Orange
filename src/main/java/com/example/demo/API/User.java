package com.example.demo.API;
import java.util.Date;
public class User {
    private Long msisdn;
    private Date date;

    public User(long msisdn) {
        this.msisdn = msisdn;
    }

    public Long getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(Long msisdn) {
        this.msisdn = msisdn;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "User{" +
                "msisdn=" + msisdn +
                ", date=" + date +
                '}';
    }
    
}
