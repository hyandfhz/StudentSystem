package com.unicorn.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

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

    public String getUserInformation(File userDirectory, String field) throws IOException {


        return fileReader.getFileString(new File(userDirectory, field));
    }
}
