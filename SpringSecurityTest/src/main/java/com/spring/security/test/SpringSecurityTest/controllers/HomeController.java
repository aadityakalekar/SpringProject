package com.spring.security.test.SpringSecurityTest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@PreAuthorize("hasAuthoruty('ROLE_NORMAL')")
	@GetMapping("/normal")
	public ResponseEntity<String> normalUser(){
		
		return ResponseEntity.ok("Yes, I am normal user");
	}
	
	@PreAuthorize("hasAuthoruty('ROLE_ADMIN')")
	@GetMapping("/admin")
	public ResponseEntity<String> adminUser(){
		
		return ResponseEntity.ok("Yes, I am admin user");
	}

	@GetMapping("/public")
	public ResponseEntity<String> publicUser(){
		
		return ResponseEntity.ok("Yes, I am public user");
	}
}
