package com.spring_core.bean_lesson.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring_core.bean_lesson.config.AppConfig;

public class LoginService {

    public void login() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
    }
    
}
