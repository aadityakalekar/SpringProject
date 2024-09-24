package com.jwt.example.model;

import lombok.*;

@Data  // Includes getters, setters, toString, equals, and hashCode
@NoArgsConstructor  // Generates a no-args constructor
@AllArgsConstructor // Generates an all-args constructor
@Builder            // Generates the builder pattern
public class JWTResponse {
    private String jwtToken;
    private String username;

    public static Object builder() {
        return "builder";
    }
}
