package com.unicorn.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
public class LoginController {
    @RequestMapping("/Login")
    public ModelAndView loginController() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }

    @ResponseBody
    @RequestMapping(value = "/UserLoginCheck", method = RequestMethod.POST)
    public String userLoginCheckController(String userName, String userPassWord) {
        if (!Objects.equals(userName, "unicorn")) {
            return "UserName is Wrong";
        } else if (!Objects.equals(userPassWord, "123456")) {
            return "PassWord is Wrong";
        } else {
            return "OK,Pass!";
        }
    }
}