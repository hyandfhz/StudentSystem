package com.unicorn.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;

@Repository
public class Users {
    @Autowired
    ReadFile fileReader;
    @Autowired
    ReadDirectory directoryReader;

    public boolean userExists(String type, String userName) {
        return getUserDirectory(type, userName).exists();
    }

    public File getUserDirectory(String type, String userName) {
        return new File("./data/user/" + type + "/" + userName);
    }

    public String getUserInformation(String type, String userName, String field) throws IOException {
        if (userExists(type, userName)) {
            return fileReader.getFileString(new File(getUserDirectory(type, userName), field));
        }
        else {
            return null;
        }
    }
}
