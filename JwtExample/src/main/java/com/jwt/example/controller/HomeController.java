package com.jwt.example.controller;


import com.jwt.example.model.User;
import com.jwt.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> getUser(){
        System.out.println("Getting users");
        return this.userService.getUsers();
    }

    @GetMapping("/current-user")//to check which user is currently logged in
    public String getLoggedInUser(Principal principal){
        return principal.getName();
    }
}
