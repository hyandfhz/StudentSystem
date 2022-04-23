package com.unicorn.service.dao;

import org.springframework.stereotype.Repository;

import java.io.*;

@Repository
public class ReadFile {
    public String getFileString(File file) throws IOException {
        InputStream in = new FileInputStream(file);
        StringBuilder target = new StringBuilder();
        int size = in.available();
        for (int i = 1; i <= size; i++) {
            target.append((char) in.read());
        }
        in.close();
        return target.toString();
    }

    public int getFileInt(File file) throws IOException {
        return Integer.parseInt(getFileString(file));
    }

    public File getCreateFile(File directory, String fileName) throws IOException {
        File target = new File(directory, fileName);
        if (!(target.exists() && !target.isDirectory())) {
            System.out.println("Create file '" + directory.getCanonicalPath() + fileName + "': " + target.createNewFile());
        }
        return target;
    }

    public void writeFile(File file, String data) throws IOException {
        new FileWriter(file).write(data);
    }

    public void appendFile(File file, String data) throws IOException {
        new FileWriter(file, true).write(data);
    }
}
