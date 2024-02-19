package com.example.demo.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void SaveNewUser(User user){
        String sql = "INSERT INTO Users (Msisdn, LoginDay) values (?,?)";
        template.update(sql, user.getMsisdn(),user.getDate());
    }



}
