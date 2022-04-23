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
    ControllerUser controllerUser;

    public void init(File settingsFile) throws ConfigurationException, IOException {
        PropertiesConfiguration settingsConfiguration = new PropertiesConfiguration();
        // 获取配置文件里的
        settingsConfiguration.load(settingsFile);
        String rootUserName = settingsConfiguration.getString("rootUserName");
        String rootUserPassword = settingsConfiguration.getString("rootUserPassword");
        settingsConfiguration.setProperty("ready", "ready");
        settingsConfiguration.clearProperty("rootUserName");
        settingsConfiguration.clearProperty("rootUserPassword");
        FileWriter settingsWriter = new FileWriter(settingsFile);
        settingsConfiguration.save(settingsWriter);

        // 建一个数据库
        readDirectory.removeDirectory("./data");
        readDirectory.getCreateDirectory("./data");

        // 创建user DB
        readDirectory.getCreateDirectory("./data/user");
        readDirectory.getCreateDirectory("./data/user/student");
        readDirectory.getCreateDirectory("./data/user/teacher");
        readDirectory.getCreateDirectory("./data/user/controller");
        // 创建root用户
        controllerUser.CreateController(rootUserName, rootUserPassword);
    }
}
