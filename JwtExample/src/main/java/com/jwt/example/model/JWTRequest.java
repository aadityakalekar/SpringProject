package com.jwt.example.model;

import lombok.*;

@Data  // Includes getters, setters, toString, equals, and hashCode
@NoArgsConstructor  // Generates a no-args constructor
@AllArgsConstructor // Generates an all-args constructor
@Builder            // Generates the builder pattern
public class JWTRequest {
    private String email;
    private String password;

    public String getEmail() {
        return "email";
    }

    public String getPassword() {
        return "password";
    }
}
