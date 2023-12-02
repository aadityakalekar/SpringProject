
package com.boot.employee.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.employee.model.Employee;
import com.boot.employee.service.EmployeeService;

class EmployeeControllerTest {

	@InjectMocks
	private EmployeeController employeeController;

	@Mock
	private EmployeeService employeeService;

	@Mock
	private Model model;
	
	@Mock
	private ModelMap modelmap;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void testHome() {
		String viewName = employeeController.Home();
		assertEquals("index", viewName);

	}

	@Test
	public void testRegister() {
		String viewName = employeeController.register();
		assertEquals("register", viewName);
	}

	@Test
	public void testSaveEmployee() {
		Employee employee = new Employee(1, "test@gmail.com", "test", "Test", (float) 1000.00);
		when(employeeService.saveEmployee(employee)).thenReturn(employee);
		String viewName = employeeController.saveEmployee(employee, null);
		assertEquals("registersuccess", viewName);

	}

	@Test
	public void testViewAllEmployee() {
		List<Employee> employees = new ArrayList();
		employees.add(new Employee(1, "test1@gmail.com", "test1", "Test1", (float) 1500.00));
		when(employeeService.viewAllEmployee()).thenReturn((employees));
		String viewName = employeeController.viewAllEmployee(model);
		assertEquals("viewAllEmployee", viewName);
	}

	
	@Test
	public void testViewSortedEmployee() {
		List<Employee> employees = new ArrayList();
		employees.add(new Employee(1, "test1@gmail.com", "test1", "Test1", (float) 1500.00));
        employees.add(new Employee(2, "test2@gmail.com", "test2", "Test2", (float) 2000.00));
		when(employeeService.viewSortedEmployee()).thenReturn((employees));
		String viewName = employeeController.viewSortedEmployee(model);
		assertEquals("viewSortedEmployee", viewName);
	}
	
	@Test
	public void viewEmployeeById() {
		Integer empId =1;
		Employee employee = new Employee(1, "test@gmail.com", "test", "Test", (float) 1000.00);
		when(employeeService.viewEmployeeById(empId)).thenReturn(employee);
		String viewname = employeeController.viewEmployeeById(empId, modelmap);
		assertEquals("viewEmployeeById", viewname);
	
	}
	
	///--------------------------------------------
	
	@Test
	public void operationForm() {
		String viewName = employeeController.operationForm();
		assertEquals("operationForm", viewName);
			}
}
