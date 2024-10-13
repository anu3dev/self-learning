package com.anu3dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anu3dev.model.Users;
import com.anu3dev.service.UserLogin;

@RestController
public class UsersLogin {

    @Autowired
    private UserLogin service;

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return service.register(user);
    }
    
    @PostMapping("/login")
    public String login(@RequestBody Users user) {
        return service.verify(user);
    }
}