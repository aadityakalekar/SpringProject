package com.jwt.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
//use this above annotations instead of generating getters,setters,etc
public class User {
    private String userid;
    private String name;
    private String email;

    public User(String userid, String name, String email) {
        this.userid = userid;
        this.name = name;
        this.email = email;
    }

    public User(String string) {
    }
}
