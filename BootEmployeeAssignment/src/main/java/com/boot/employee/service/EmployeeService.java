package com.boot.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.boot.employee.model.Employee;

@Service
public interface EmployeeService {

	public Employee saveEmployee(Employee Employee);

	public List<Employee> viewAllEmployee();

	public List<Employee> viewSortedEmployee();

	public Employee viewEmployeeById(Integer id);
	
	public int deleteEmployeeById(Integer id);

	/* public int UpdateEmployee(Employee employee); */
	


}
