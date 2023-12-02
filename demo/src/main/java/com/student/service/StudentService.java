package com.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repository.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo studRepo;
	
	public List<Student> getStudInfo(){
		List<Student> StudentInfo= new ArrayList<>();
		studRepo.findAll().forEach(StudentInfo::add);
		return StudentInfo;
	}
	public void updateStudent(int id, Student student) {
		if(studRepo.findById(id)!=null) {
			Student stud=new Student();
			stud.setId(student.getId());
			stud.setEmail(student.getEmail());
			stud.setFname(student.getFname());
			stud.setLname(student.getLname());
			stud.setAddr(student.getAddr());
			
			studRepo.save(stud);
		}
	}
}
