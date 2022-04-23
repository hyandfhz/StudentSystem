package com.unicorn.service;

import com.unicorn.service.dao.InitData;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

@SpringBootApplication
public class ServiceApplication {
    private static ApplicationContext applicationContext;

    private static int port = 8080;

    public static void main(String[] args) throws ConfigurationException {
        loadPort();
        applicationContext = SpringApplication.run(ServiceApplication.class, args);
        initData();
    }

    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        return new TomcatServletWebServerFactory(port);
    }

    private static void initData() {
        File settingsFile = InitSettings();
        if (settingsFile.exists()) {
            try {
                //读配置
                PropertiesConfiguration settingsConfiguration = new PropertiesConfiguration();
                settingsConfiguration.load(settingsFile.getCanonicalFile());

                if (!Objects.equals(settingsConfiguration.getString("ready"), "false")) {
                    //设置端口
                    port = settingsConfiguration.getInt("port");

                    if (Objects.equals(settingsConfiguration.getString("ready"), "true")) {
                        InitData initData = applicationContext.getBean("initData", InitData.class);
                        initData.init(settingsFile);
                    }
                    settingsConfiguration.reload();
                    if (Objects.equals(settingsConfiguration.getString("ready"), "ready")) {
                        System.out.println("Ready!");
                    }
                } else {
                    System.out.println("Please configure the initialization file first!");
                    System.exit(1);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (ConfigurationException e) {
                e.printStackTrace();
            }
        }
    }

    private static void loadPort() throws ConfigurationException {
        File settingsFile = InitSettings();
        port = new PropertiesConfiguration(settingsFile).getInt("port");
    }

    private static File InitSettings() {
        File settingsDirectory = new File(".");
        File settingsFile = new File(settingsDirectory, "settings.properties");
        try {
            if (settingsFile.createNewFile()) {
                //写入默认内容
                FileWriter settingsWriter = new FileWriter(settingsFile);
                settingsWriter.write("#Normal (Can be rewritten before every time before running)\n");
                settingsWriter.write("port=8080\n");
                settingsWriter.write("#Init (Set only first time)\n");
                settingsWriter.write("rootUserName=root\n");
                settingsWriter.write("rootUserPassword=123456\n");
                settingsWriter.write("#Configuration (only rewrite it before init)\n");
                settingsWriter.write("ready=false\n");
                settingsWriter.flush();
                settingsWriter.close();
                System.out.println("Created configuration...");
            }
        } catch (IOException ioException) {
            System.out.println("Exception thrown  :" + ioException);
        }
        return settingsFile;
    }
}
