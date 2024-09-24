package com.jwt.example;

import ch.qos.logback.core.net.SyslogOutputStream;
import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtExampleApplication {

	public static void main(String[] args) {

		SpringApplication.run(JwtExampleApplication.class, args);
		System.out.println("JWT with Spring boot");
	}

}
