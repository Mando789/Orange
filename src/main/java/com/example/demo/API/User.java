package com.example.demo.API;

public class User {
    private long msisdn;

    @Override
    public String toString() {
        return "model{" +
                "msisdn=" + msisdn +
                '}';
    }

    public User(long msisdn) {
        this.msisdn = msisdn;
    }

    public long getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(long msisdn) {
        this.msisdn = msisdn;
    }
}
