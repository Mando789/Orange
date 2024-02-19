package com.example.demo.API;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private List<User> userList;

    public UserService(){
        userList = new ArrayList<>();

        User User1= new User(01);
        User User2= new User(02);
        User User3= new User(03);
        User User4= new User(04);

        userList.addAll(Arrays.asList(User1,User2,User3,User4));

    }

    public long getId(long msisdn) {
        for (User user : userList){
            if (msisdn == user.getMsisdn()){
                return user.getMsisdn();
            }
        }
        return 0;
    }
}
