package com.example.demo.API.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.util.Optional;

public class Dials {

    @Id
    private Integer id;

    private Long msisdn;


    private Integer groupId;

    public Dials() {
    }

    public Dials(Long msisdn) {
        this.msisdn = msisdn;
    }

    public Dials(Long msisdn, Integer groupId) {
        this.msisdn = msisdn;
        this.groupId = groupId;
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

    public Integer getGroupId() {
        return groupId;
    }


    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "Dials{" +
                "id=" + id +
                ", msisdn=" + msisdn +
                ", groupId=" + groupId +
                '}';
    }
}
