package com.example.demo.API.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;


@Table ("HREDEMPTION")
public class HRedemption {

    @Id
    private Integer id;
    private Long msisdn;
    private Integer giftId;
    private Integer groupId;
    private LocalDate redemptionDate;



    /////// trying but delete this if it didn't work
    public HRedemption(Integer id, Long msisdn, Integer giftId, Integer groupId, LocalDate redemptionDate) {
        this.id = id;
        this.msisdn = msisdn;
        this.giftId = giftId;
        this.groupId = groupId;
        this.redemptionDate = redemptionDate;
    }

    public HRedemption(Long msisdn, Integer giftId, Integer groupId, LocalDate redemptionDate) {
        this.msisdn = msisdn;
        this.giftId = giftId;
        this.groupId = groupId;
        this.redemptionDate = redemptionDate;
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

    public LocalDate getRedemptionDate() {
        return redemptionDate;
    }

    public void setRedemptionDate(LocalDate redemptionDate) {
        this.redemptionDate = redemptionDate;
    }

    @Override
    public String toString() {
        return "HRedemption{" +
                "id=" + id +
                ", msisdn=" + msisdn +
                ", giftId=" + giftId +
                ", groupId=" + groupId +
                ", date=" + redemptionDate +
                '}';
    }
}
