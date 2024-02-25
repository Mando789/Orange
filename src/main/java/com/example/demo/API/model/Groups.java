package com.example.demo.API.model;

import org.springframework.data.annotation.Id;

public class Groups {
    @Id
    private Integer id;

    private  Integer giftId;

    public Groups(Integer id, Integer giftId) {
        this.id = id;
        this.giftId = giftId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public  Integer getGiftId() {
        return giftId;
    }

    public void setGiftId( Integer giftId) {
        this.giftId = giftId;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", giftId=" + giftId +
                '}';
    }
}
