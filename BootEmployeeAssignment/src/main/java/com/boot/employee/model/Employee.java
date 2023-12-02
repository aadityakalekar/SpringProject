package com.boot.employee.model;

import java.io.Serializable;
import jakarta.persistence.*;


/*
 The persistent class for the employee database table.
 */
@Entity
@Table(name="employee")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", dept=" + dept + ", email=" + email + ", name=" + name + ", salary="
				+ salary + "]";
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_id", unique=true, nullable=false)
	private int empId;

	@Column(nullable=false, length=45)
	private String dept;

	@Column(nullable=false, length=45)
	private String email;

	@Column(nullable=false, length=45)
	private String name;

	@Column(nullable=false, length=45)
	private Float salary;
	
	

	public Employee(int empId,  String email,String name, String dept, Float salary) {
		super();
		this.empId = empId;
		this.dept = dept;
		this.email = email;
		this.name = name;
		this.salary = salary;
	}

	public Employee() {
	}

	public int getEmpId() {
		return this.empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getDept() {
		return this.dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getSalary() {
		return this.salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

}