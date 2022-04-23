package com.unicorn.service.dao;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Repository
public class InitData {
    @Autowired
    public ReadDirectory readDirectory;
    @Autowired
    public ReadFile readFile;
    @Autowired
    Users users;

    public void init(File settingsFile) throws ConfigurationException, IOException {
        PropertiesConfiguration settingsConfiguration = new PropertiesConfiguration();
        // 获取配置文件里的
        settingsConfiguration.load(settingsFile);
        String rootName = settingsConfiguration.getString("rootUserName");
        String rootPWD = settingsConfiguration.getString("rootUserPassword");
        settingsConfiguration.setProperty("ready", "ready");
        settingsConfiguration.clearProperty("rootUserName");
        settingsConfiguration.clearProperty("rootUserPassword");
        FileWriter settingsWriter = new FileWriter(settingsFile);
        settingsConfiguration.save(settingsWriter);

        // 创建user DB
        readDirectory.getCreateDirectory("./data");
        readDirectory.getCreateDirectory("./data/user");
        readDirectory.getCreateDirectory("./data/user/student");
        readDirectory.getCreateDirectory("./data/user/teacher");
        readDirectory.getCreateDirectory("./data/user/controller");

        // 创建root用户

    }
}
