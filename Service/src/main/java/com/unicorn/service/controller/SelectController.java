package com.unicorn.service.controller;

import com.unicorn.service.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SelectController {
    @Autowired
    TeacherMapper teacherMapper;
    @ResponseBody
    @RequestMapping("/select")
    public String selectController(){
        return teacherMapper.getTeacher(1).toString();
    }
}
