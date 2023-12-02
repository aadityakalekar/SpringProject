package com.boot.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.employee.model.Employee;
import com.boot.employee.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo repo;

	@Override
	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);
	}
	
	

	@Override
	public List<Employee> viewAllEmployee() {
		return repo.findAll();
	}

	@Override
	public Employee viewEmployeeById(Integer id) {
		return repo.findById(id).orElse(new Employee());

	}

	// custom query
	@Override
	public List<Employee> viewSortedEmployee() {
	return repo.selectRecordByDeptAndSalaryDesc();
		//return repo.findByDeptOrderBySalaryDesc();
	}

	@Override
	public int  deleteEmployeeById(Integer id) {
	 repo.deleteById(id);
	 return id;
	}


/*
	@Override
	public int UpdateEmployee(Employee employee) {
		System.out.println(employee.getEmpId());
		System.out.println(employee.getEmail());
		System.out.println(employee.getName());
		System.out.println(employee.getDept());
		System.out.println(employee.getSalary());
		
	repo.updateEmployee(employee);
	
		return employee.getEmpId();
		
	}
	*/
	

	
}
