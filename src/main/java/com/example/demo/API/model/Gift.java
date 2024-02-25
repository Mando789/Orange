package com.example.demo.API.model;

import org.springframework.data.annotation.Id;

public class Gift {

    @Id
    private Integer id;

    private String name;

    public Gift(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Gift{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
