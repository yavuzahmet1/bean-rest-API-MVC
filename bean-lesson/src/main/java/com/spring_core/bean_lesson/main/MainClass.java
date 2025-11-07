package com.spring_core.bean_lesson.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring_core.bean_lesson.config.AppConfig;
import com.spring_core.bean_lesson.model.User;
import com.spring_core.bean_lesson.services.LoginService;
import com.spring_core.bean_lesson.services.UserService;


public class MainClass {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        for (User user : userService.getUserList()) {
            System.out.println(user.toString());
        }
        
        LoginService loginService = new LoginService();
        loginService.login();

  
        
        
    }
}
