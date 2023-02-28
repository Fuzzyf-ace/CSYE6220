package com.daiming.part8;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class Part8Controller {

    @Autowired
    RandomStringUtil randomStringUtil;
    @GetMapping("/string")
    public ModelAndView getString(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("string");
        System.out.println("getBean: " + randomStringUtil);
        modelAndView.addObject("message", randomStringUtil.generate());
        return modelAndView;
    }
}
