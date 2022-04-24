package com.unicorn.service.pojo;

import org.springframework.stereotype.Component;

@Component
public class Teacher {
    private int TeacherId;
    private String TeacherName;
    private String LoginId;
    private String PassWord;
    private String TeacherMobile;
    private String CreateTime;
    private String Status;
    private String Role;

    public void setTeacherId(int teacherId) {
        TeacherId = teacherId;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }

    public void setLoginId(String loginId) {
        LoginId = loginId;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public void setTeacherMobile(String teacherMobile) {
        TeacherMobile = teacherMobile;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setRole(String role) {
        Role = role;
    }

    public int getTeacherId() {
        return TeacherId;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public String getLoginId() {
        return LoginId;
    }

    public String getPassWord() {
        return PassWord;
    }

    public String getTeacherMobile() {
        return TeacherMobile;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public String getStatus() {
        return Status;
    }

    public String getRole() {
        return Role;
    }

    public Teacher() {
    }

    public Teacher(int teacherId, String teacherName, String loginId, String passWord, String teacherMobile, String createTime, String status, String role) {
        TeacherId = teacherId;
        TeacherName = teacherName;
        LoginId = loginId;
        PassWord = passWord;
        TeacherMobile = teacherMobile;
        CreateTime = createTime;
        Status = status;
        Role = role;
    }

    @Override
    public String toString() {
        return "{\"Teacher\":{"
                + "\"TeacherId\":"
                + TeacherId
                + ",\"TeacherName\":\""
                + TeacherName + '\"'
                + ",\"LoginId\":\""
                + LoginId + '\"'
                + ",\"PassWord\":\""
                + PassWord + '\"'
                + ",\"TeacherMobile\":\""
                + TeacherMobile + '\"'
                + ",\"CreateTime\":\""
                + CreateTime + '\"'
                + ",\"Status\":\""
                + Status + '\"'
                + ",\"Role\":\""
                + Role + '\"'
                + "}}";

    }
}
