package com.capgemini.springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springboot.demo.model.Employee;
import com.capgemini.springboot.demo.service.EmployeeService;

@RestController
public class EmployeeController {

//	EmployeeService service = new EmployeeService();
	@Autowired
	private EmployeeService service;

//	http://localhost:8088/get-employee-by-id
	@GetMapping("/get-employee-by-id")
	public Employee getEmployeeById() {
		int employeeId = 101;
		System.out.println("EmployeeController getEmployeeById");
		return service.getEmpById(employeeId);
	}

//	http://localhost:8088/get-all-employees
	@GetMapping("/get-all-employees")
	public List<Employee> getAllEmployees() {
		System.out.println("get-all-employees");
		return null;
	}

//  public Employee addEmployee() {
//		return null;
//	}

//	public Employee updateEmployee() {
//	return null;
//}

//	public Employee deleteEmployee() {
//	return null;
//}

}

//package com.capgemini.springboot.demo.controller;
//
//import java.util.List;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.capgemini.springboot.demo.model.Employee;
//
//@RestController
//public class EmployeeController {
//
////	http://localhost:8088/get-employee-by-id
//	@GetMapping("/get-employee-by-id")
//	public Employee getEmployeeById() {
//		Employee emp = new Employee(101, "Sonu", 50000);
//		System.out.println(emp.toString());
//		return emp;
//	}
//
////	http://localhost:8088/get-all-employees
//	@GetMapping("/get-all-employees")
//	public List<Employee> getAllEmployees() {
//		System.out.println("get-all-employees");
//		return null;
//	}
//
////  public Employee addEmployee() {
////		return null;
////	}
//
////	public Employee updateEmployee() {
////	return null;
////}
//
////	public Employee deleteEmployee() {
////	return null;
////}
//
//}
