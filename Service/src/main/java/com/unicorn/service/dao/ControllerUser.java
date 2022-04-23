package com.unicorn.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ControllerUser {
    @Autowired
    Users users;

    public boolean CreateController(String userName, String userPassWord) throws IOException {
        if (!users.userExists("controller", userName)) {
            Map<String, String> data = new HashMap<String, String>();
            data.put("userName", userName);
            data.put("userPassword", userPassWord);
            users.CreateUser("controller", data);
            return true;
        } else {
            return false;
        }
    }
}
