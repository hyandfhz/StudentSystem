package com.unicorn.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Repository
public class Users {
    @Autowired
    private ReadFile fileReader;
    @Autowired
    private ReadDirectory directoryReader;

    public boolean userExists(String type, String userName) {
        return getUserDirectory(type, userName).exists();
    }

    public File getUserDirectory(String type, String userName) {
        return new File("./data/user/" + type + "/" + userName);
    }

    public String getUserInformation(String type, String userName, String field) throws IOException {
        if (userExists(type, userName)) {
            return fileReader.getFileString(new File(getUserDirectory(type, userName), field));
        } else {
            return null;
        }
    }

    public void CreateUser(String type, Map<String, String> data) throws IOException {
        String userName = data.get("userName");
        File directory = getUserDirectory("controller", userName);
        directoryReader.getCreateDirectory(directory.getAbsolutePath());
        data.remove("userName");
        for (Map.Entry<String, String> entry : data.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            fileReader.writeFile(fileReader.getCreateFile(directory, key), value);
        }
    }
}
