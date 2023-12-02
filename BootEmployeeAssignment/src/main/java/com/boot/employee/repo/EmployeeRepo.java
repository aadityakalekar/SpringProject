package com.boot.employee.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.boot.employee.model.Employee;



@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	@Query("FROM Employee e ORDER BY e.dept ASC, e.salary DESC")	
	List<Employee> selectRecordByDeptAndSalaryDesc();
	
	/*
	 * @Query("update Employee e set e.name=employee.getName(),e.email=employee.getEmail(),e.dept=employee.getDept(),e.salary=employee.getSalary() where e.empd_id=employee.getEmpId()"
	 * ) void updateEmployee(Employee employee);
	 */
	
	
	 //List<Employee> findByDeptOrderBySalaryDesc(String dept);
	
	 //List<Employee> findByDeptOrderBySalaryDesc(String dept);
}