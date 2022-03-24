package com.capgemini.springboot.demo.service;

import org.springframework.stereotype.Service;

import com.capgemini.springboot.demo.model.Employee;

@Service
public class EmployeeService {

	public Employee getEmpById(int employeeId) {
		System.out.println("EmployeeService getEmpById");
//		Employee emp = get data from DB using repository
		Employee emp = new Employee(employeeId, "Sonu", 50000);
		System.out.println(emp.toString());
		return emp;
	}

}
