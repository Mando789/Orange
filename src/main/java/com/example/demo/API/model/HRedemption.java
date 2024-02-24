package com.example.demo.API.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class HRedemption {

    @Id
    private Integer id;
    private Long msisdn;
    private Integer giftId;
    private Integer groupId;
    private LocalDate date;

    public HRedemption(Long msisdn, Integer giftId, Integer groupId, LocalDate date) {
        this.msisdn = msisdn;
        this.giftId = giftId;
        this.groupId = groupId;
        this.date = date;
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

    public void setGiftId(Integer giftId) {
        this.giftId = giftId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "HRedemption{" +
                "id=" + id +
                ", msisdn=" + msisdn +
                ", giftId=" + giftId +
                ", groupId=" + groupId +
                ", date=" + date +
                '}';
    }
}
