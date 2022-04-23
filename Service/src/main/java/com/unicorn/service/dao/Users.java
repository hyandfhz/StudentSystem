package com.unicorn.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;

@Repository
public class Users {
    @Autowired
    ReadFile fileReader;
    @Autowired
    ReadDirectory directoryReader;

    public boolean userExists(String type, String userName) {
        return getUser(type, userName).exists();
    }

    public File getUser(String type, String userName) {
        return new File("./data/user/" + type + "/" + userName);
    }
}
