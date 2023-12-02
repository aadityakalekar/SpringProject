package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
	@Query("SELECT u FROM Student u WHERE u.Stud_email = ?1 AND Stud_pass = ?2")

	 Student findByEmailAndPass(String Stud_email, String Stud_pass);
}
