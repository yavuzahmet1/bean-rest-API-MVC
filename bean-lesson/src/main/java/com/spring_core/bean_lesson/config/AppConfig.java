package com.spring_core.bean_lesson.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring_core.bean_lesson.model.User;
import com.spring_core.bean_lesson.services.UserService;

@Configuration
public class AppConfig {

    @Bean
    public UserService userService() {
        UserService userService = new UserService();

        List<User> userList=new ArrayList<>();
        userList.add(new User("Alice"));
        userList.add(new User("Bob"));
        userService.setUserList(userList);

        userService.setUserList(userList);

        return userService;
    }
    
}
