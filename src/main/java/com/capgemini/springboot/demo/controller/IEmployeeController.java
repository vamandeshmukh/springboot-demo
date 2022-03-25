package com.capgemini.springboot.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capgemini.springboot.demo.model.Employee;

public interface IEmployeeController {

	public abstract ResponseEntity<Employee> getEmployeeById(int employeeId);

	public abstract ResponseEntity<List<Employee>> getAllEmployees();

	public abstract ResponseEntity<Employee> addEmployee(Employee employee);

	public abstract ResponseEntity<Employee> updateEmployee(Employee employee);

	public abstract ResponseEntity<Employee> deleteEmployee(int employeeId);

}
