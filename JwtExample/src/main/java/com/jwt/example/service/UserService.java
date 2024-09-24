package com.jwt.example.service;


import com.jwt.example.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private List<User> store= new ArrayList<>();

    public UserService() {
        store.add(new User(UUID.randomUUID().toString(),"John Doe","john@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Jane Smith","jane@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Alice Johnson","alice@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Bob Marley","bob@gmail.com"));

    }

    public List<User> getUsers() {
        return this.store;
    }
}
