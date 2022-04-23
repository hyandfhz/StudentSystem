package com.unicorn.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @RequestMapping("/")
    public ModelAndView indexController() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "unicorn");

        mav.setViewName("index");
        return mav;
    }
}
