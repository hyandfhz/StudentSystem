package com.unicorn.service.dao;

import org.springframework.stereotype.Repository;

import java.io.File;

@Repository
public class ReadDirectory {
    File getCreateDirectory(String path) {
        File target = new File(path);
        if (!target.isDirectory()) {
            System.out.println("Create directory '" + path + "': " + target.mkdir());
        }
        return target;
    }

    boolean directoryExists(String path) {
        return new File(path).exists();
    }

    void removeDirectory(String path) {
        if(directoryExists(path)) {
            new File(path).delete();
        }
    }
}
