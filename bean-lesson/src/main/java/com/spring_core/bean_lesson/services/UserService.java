package com.spring_core.bean_lesson.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring_core.bean_lesson.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class UserService {
    private List<User> userList;

    public void doSomething() {
        System.out.println("UserService is doing something.");
    }
}
