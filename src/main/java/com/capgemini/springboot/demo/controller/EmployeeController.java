package com.capgemini.springboot.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springboot.demo.model.Employee;
import com.capgemini.springboot.demo.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EmployeeService service;

////	http://localhost:8088/emp/get-employee-by-id/{eid}
//	@GetMapping("/get-employee-by-id/{eid}")
//	public ResponseEntity<Employee> getEmployeeById(@PathVariable(name = "eid") int employeeId) {
//		LOG.info("EmployeeController getEmployeeById " + employeeId);
//		Employee emp = service.getEmpById(employeeId);
//		ResponseEntity<Employee> response = new ResponseEntity<>(emp, HttpStatus.OK);
//		return response;
//	}

//	http://localhost:8088/emp/get-employee-by-id/{eid}
	@GetMapping("/get-employee-by-id/{eid}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(name = "eid") int employeeId) {
		LOG.info("EmployeeController getEmployeeById " + employeeId);
		Employee emp = service.getEmpById(employeeId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee " + employeeId + " was found successfully.");
		ResponseEntity<Employee> response = new ResponseEntity<>(emp, headers, HttpStatus.OK);
		return response;
	}

	// http://localhost:8088/emp/get-all-employees
	@GetMapping("/get-all-employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		LOG.info("get-all-employees");
		List<Employee> empList = service.getAllEmps();
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employees were found successfully.");
		ResponseEntity<List<Employee>> response = new ResponseEntity<>(empList, headers, HttpStatus.OK);
		return response;
	}

//	http://localhost:8088/emp/add-employee 
	@PostMapping("/add-employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		LOG.info(employee.toString());
		Employee emp = service.addEmp(employee);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee " + emp.getEmployeeId() + " was created successfully.");
		ResponseEntity<Employee> response = new ResponseEntity<>(emp, headers, HttpStatus.CREATED);
		return response;
	}

//	http://localhost:8088/emp/update-employee 
	@PutMapping("/update-employee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		LOG.info(employee.toString());
		Employee emp = service.updateEmp(employee);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee " + emp.getEmployeeId() + " was updated successfully.");
		ResponseEntity<Employee> response = new ResponseEntity<>(emp, headers, HttpStatus.OK);
		return response;
	}

//	http://localhost:8088/emp/delete-employee/{eid} 
	@DeleteMapping("/delete-employee/{eid}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(name = "eid") int employeeId) {
		LOG.info(Integer.toString(employeeId));
		Employee emp = service.deleteEmp(employeeId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee " + employeeId + " was deleted successfully.");
		ResponseEntity<Employee> response = new ResponseEntity<>(emp, headers, HttpStatus.OK);
		return response;
	}

}

//package com.capgemini.springboot.demo.controller;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.capgemini.springboot.demo.model.Employee;
//import com.capgemini.springboot.demo.service.EmployeeService;
//
//@RestController
//public class EmployeeController {
//
//	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
//
//	@Autowired
//	private EmployeeService service;
//
////	http://localhost:8088/get-employee-by-id/{eid}
//	@GetMapping("/get-employee-by-id/{eid}")
//	public Employee getEmployeeById(@PathVariable(name = "eid") int employeeId) {
//		LOG.info("EmployeeController getEmployeeById " + employeeId);
//		return service.getEmpById(employeeId);
//	}
//
////	http://localhost:8088/get-all-employees
//	@GetMapping("/get-all-employees")
//	public List<Employee> getAllEmployees() {
//		LOG.info("get-all-employees");
//		return service.getAllEmps();
//	}
//
////	http://localhost:8088/add-employee 
//	@PostMapping("/add-employee")
//	public Employee addEmployee(@RequestBody Employee employee) {
//		LOG.info(employee.toString());
//		return service.addEmp(employee);
//	}
//
////	http://localhost:8088/update-employee 
//	@PutMapping("/update-employee")
//	public Employee updateEmployee(@RequestBody Employee employee) {
//		LOG.info(employee.toString());
//		return service.updateEmp(employee);
//	}
//
////	http://localhost:8088/delete-employee/{eid} 
//	@DeleteMapping("/delete-employee/{eid}")
//	public Employee deleteEmployee(@PathVariable(name = "eid") int employeeId) {
//		LOG.info(Integer.toString(employeeId));
//		return service.deleteEmp(employeeId);
//	}
//
//}

//package com.capgemini.springboot.demo.controller;
//
//import java.util.List;
//import java.util.Random;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.capgemini.springboot.demo.model.Employee;
//import com.capgemini.springboot.demo.service.EmployeeService;
//
//@RestController
//public class EmployeeController {
//
//	@Autowired
//	private EmployeeService service;
//
////	http://localhost:8088/get-employee-by-id
//	@GetMapping("/get-employee-by-id")
//	public Employee getEmployeeById() {
//		int employeeId = new Random().nextInt(6) + 100;
//		System.out.println("EmployeeController getEmployeeById " + employeeId);
//		return service.getEmpById(employeeId);
//	}
//
////	http://localhost:8088/get-all-employees
//	@GetMapping("/get-all-employees")
//	public List<Employee> getAllEmployees() {
//		System.out.println("get-all-employees");
//		return service.getAllEmps();
//	}
//
//	@PostMapping("/add-employee")
//	public Employee addEmployee() {
//		Employee employee = new Employee();
//		return service.addEmp(employee);
//	}
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
