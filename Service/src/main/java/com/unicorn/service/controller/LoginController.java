package com.unicorn.service.controller;

import com.unicorn.service.mapper.TeacherMapper;
import com.unicorn.service.pojo.Message;
import com.unicorn.service.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @Autowired
    TeacherMapper teacherMapper;

    @RequestMapping("/Login")
    public ModelAndView loginController() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }

    @ResponseBody
    @RequestMapping(value = "/UserLoginCheck", method = RequestMethod.POST)
    public String userLoginCheckController(String userName, String userPassWord) {
        Teacher teacher;
        Message target = new Message();
        teacher = teacherMapper.getTeacherByLoginId(userName);
        if (teacher == null) {
            teacher = teacherMapper.getTeacherByTeacherMobile(userName);
            if (teacher == null) {
                target.setStatus(false);
                target.setMessage("用户不存在!请检查您的信息哦!");
                return target.toString();
            }
        }
        if (userPassWord.equals(teacher.getPassWord())) {
            target.setMessage("欢迎 " + teacher.getTeacherName() + " !");
            target.setStatus(true);
        } else {
            target.setMessage("您是 " + teacher.getTeacherName() + " 吗? 您的密码似乎有误, 请校对后重新登录!");
            target.setStatus(false);
        }
        return target.toString();
    }
}