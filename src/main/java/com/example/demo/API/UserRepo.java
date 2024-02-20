package com.example.demo.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

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

    public boolean MsisdnExist(Long Msisdn){
        String query = "SELECT EXISTS (SELECT 1 FROM Users WHERE Msisdn = ?)";
        Boolean flag = template.queryForObject(query,Boolean.class, Msisdn);
        return Boolean.TRUE.equals(flag);
    }

    public Date GetLastLogin(Long msisdn) {
        String query = "SELECT LoginDay FROM Users WHERE Msisdn = ? ";
        return template.queryForObject(query, Date.class, msisdn);
    }
}
