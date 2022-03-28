package com.capgemini.springboot.demo.service;

import java.util.List;

import com.capgemini.springboot.demo.model.Employee;

public interface IEmployeeService {

	public abstract Employee getEmpById(int employeeId);

	public abstract List<Employee> getEmpsByFirstName(String firstName);

	public abstract List<Employee> getAllEmps();

	public abstract Employee addEmp(Employee employee);

	public abstract Employee updateEmp(Employee employee);

	public abstract Employee deleteEmp(int employeeId);

}
