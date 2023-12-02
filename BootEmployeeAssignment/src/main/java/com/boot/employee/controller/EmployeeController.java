package com.boot.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.employee.model.Employee;
import com.boot.employee.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// Home Page
	@GetMapping("/index")
	public String Home() {
		return "index";
	}

	// Register Page
	@GetMapping("/register")
	public String register() {
		return "register"; //@PostMapping("/processform")
	}

	// save employee Data
	@PostMapping("/processform")
	public String saveEmployee(Employee employee, Model model) {
		System.out.println(employee);
		employeeService.saveEmployee(employee);
		return "registersuccess";
	}

	// view all employee data
	@GetMapping("/viewAllemployee")
	public String viewAllEmployee(Model model) {
		List<Employee> employee = employeeService.viewAllEmployee();
		model.addAttribute("employees", employee);
		return "viewAllEmployee";
	}

	// view sorted employee Data
	@GetMapping("/viewSortedEmployee")
	public String viewSortedEmployee(Model model) {
		List<Employee> employee = employeeService.viewSortedEmployee();
		model.addAttribute("employees", employee);
		return "viewSortedEmployee";
	}
	
	// get employee by id page
	@GetMapping("/empByID")
	public String empById() {
		return "selectEmpId";//postmapping viewEmployeeById
	}

	
	// view By Employee Id
	@PostMapping("/viewEmployeeById")
	public String viewEmployeeById(@RequestParam("empId") Integer empId, ModelMap model) {
		Employee employee = employeeService.viewEmployeeById(empId);
		System.out.println(employee);
		model.put("email", employee.getEmail());
		model.put("name", employee.getName());
		model.put("dept", employee.getDept());
		model.put("salary", employee.getSalary());
		return "viewEmployeeById";
	}
	
	
	
	
//---------------------------------------------------------------------------------------------//
//----------------------	// Under Developement //-----------------------------------------------------------------------
	
	//operation form page
	@GetMapping("/operationForm")
	public String operationForm() {
	return "operationForm";
		}
	
	//operation page handler method
	@PostMapping("/operation")
	public String operation(@RequestParam("empId") Integer empId, String ddlFlag,Model model) {
		if(ddlFlag.equals("select")) {
			Employee employee = employeeService.viewEmployeeById(empId);			
			return selectRecords(employee,model);
		}
		
		else if(ddlFlag.equals("delete")) {
		employeeService.deleteEmployeeById(empId);
		model.addAttribute("msg", empId);
		return "deletion";
		}
		
		else if(ddlFlag.equals("update")) {
			Employee employee= employeeService.viewEmployeeById(empId);
	        model.addAttribute("employee", employee); // Add the employee object to the model
			return "updateEmployee";
		}		
		
	    return "redirect:operationForm.html";
		
	}
		
	// Update and save employee Data
		@PostMapping("/updateSaveEmp")
		public String updateSaveEmp(Employee employee, Model model) {
			System.out.println(employee);
			 employeeService.saveEmployee(employee);
			   model.addAttribute("message", "Employee updated successfully!");
			   return "updateSuccess";
		}
			
	
	//select operation method
	public String selectRecords(Employee employee ,Model model) {
		System.out.println(employee);	
		model.addAttribute("email", employee.getEmail());
		model.addAttribute("name", employee.getName());
		model.addAttribute("dept", employee.getDept());
		model.addAttribute("salary", employee.getSalary());
		return "viewEmployeeById";	
	}
		

}
