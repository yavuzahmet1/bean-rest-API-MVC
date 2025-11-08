package com.spring_core.bean_lesson.services;


import org.springframework.stereotype.Service;



@Service
public class LoginService {
    
    private final UserService userService;
    
    // Constructor Injection
    public LoginService(UserService userService) {
        this.userService = userService;
    }
    
    public void login() {
        // UserService direkt kullanılabilir
        userService.doSomething();
        System.out.println("Login proccess executed.");
    }
}
