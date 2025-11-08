package com.spring_core.bean_lesson.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring_core.bean_lesson.config.AppConfig;
import com.spring_core.bean_lesson.model.User;
import com.spring_core.bean_lesson.services.LoginService;
import com.spring_core.bean_lesson.services.UserService;


public class MainClass {
public static void main(String[] args) {
        
       try (AnnotationConfigApplicationContext context = 
                new AnnotationConfigApplicationContext(AppConfig.class)) {
            
            UserService userService = context.getBean(UserService.class);
            
            for (User user : userService.getUserList()) {
                System.out.println(user.toString());
            }
            
            // Artık bean olarak alıyoruz
            LoginService loginService = context.getBean(LoginService.class);
            loginService.login();
            
        } // Context otomatik kapanır
}}
