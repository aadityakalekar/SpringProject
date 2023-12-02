package com.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.repository.StudentRepo;
import com.student.service.StudentService;

@RestController
public class StudentController {

	public StudentService studService;
	public StudentRepo studRepo;
	
	@GetMapping("/index")
		public String homePage() {
			return "index";
		}
	
}
