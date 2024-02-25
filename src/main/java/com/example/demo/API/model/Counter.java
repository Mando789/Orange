package com.example.demo.API.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

public class Counter {

    @Id
    private Integer id;
    private Long msisdn;
    private Integer giftId;
    private Integer counter;


    public Counter(Long msisdn, Integer giftId, Integer counter) {
        this.msisdn = msisdn;
        this.giftId = giftId;
        this.counter = counter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(Long msisdn) {
        this.msisdn = msisdn;
    }

    public Integer getGiftId() {
        return giftId;
    }

    public void setGiftId (Integer giftId) {
        this.giftId = giftId;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "id=" + id +
                ", msisdn=" + msisdn +
                ", giftId=" + giftId +
                ", counter=" + counter +
                '}';
    }
}
