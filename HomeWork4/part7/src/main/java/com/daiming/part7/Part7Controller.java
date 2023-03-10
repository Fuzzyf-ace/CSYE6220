package com.daiming.part7;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class Part7Controller {
    ApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");
    @GetMapping("/string")
    public ModelAndView getString() {
        ModelAndView modelAndView = new ModelAndView("string");
        RandomStringUtil randomStringUtil = context.getBean("randomString", RandomStringUtil.class);
        System.out.println("getBean: " + randomStringUtil);
        modelAndView.addObject("message", randomStringUtil.generate());
        return modelAndView;
    }
}
