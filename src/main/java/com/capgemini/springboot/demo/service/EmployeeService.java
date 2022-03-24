package com.capgemini.springboot.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.capgemini.springboot.demo.model.Employee;

@Service
public class EmployeeService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	private List<Employee> empList;

	{
		empList = new ArrayList<>();
		empList.add(new Employee(101, "Sonu", 50000));
		empList.add(new Employee(102, "Monu", 60000));
		empList.add(new Employee(103, "Tonu", 40000));
		empList.add(new Employee(104, "Ponu", 75000));
		empList.add(new Employee(105, "Gonu", 55000));
	}

	public Employee getEmpById(int employeeId) {
		LOG.info("EmployeeService getEmpById");
		LOG.warn("EmployeeService getEmpById");
		LOG.error("EmployeeService getEmpById");
//		Employee emp = get data from DB using repository
		Employee emp = empList.stream().filter(e -> employeeId == e.getEmployeeId()).findAny().orElse(null);
		if (null == emp)
			LOG.warn("Employee with the id " + employeeId + " not found!");
		else
			LOG.info(emp.toString());
		return emp;
	}

	public List<Employee> getAllEmps() {
		LOG.info("EmployeeService getAllEmps");
		return empList;
	}

	public Employee addEmp(Employee employee) {
		empList.add(employee);
		return employee;
	}

	public Employee updateEmp(Employee employee) {
		empList.forEach(e -> {
			if (e.getEmployeeId() == employee.getEmployeeId())
				empList.set(empList.indexOf(e), employee);
		});
		return employee;
	}

	public Employee deleteEmp(int employeeId) {
		Employee emp = this.getEmpById(employeeId);
		empList.forEach(e -> {
			if (e.getEmployeeId() == employeeId) {
				empList.remove(e);
			}
		});
		return emp;
	}
}

//package com.capgemini.springboot.demo.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//
//import com.capgemini.springboot.demo.model.Employee;
//
//@Service
//public class EmployeeService {
//
//
//	private List<Employee> empList;
//
//	{
//		empList = new ArrayList<>();
//		empList.add(new Employee(101, "Sonu", 50000));
//		empList.add(new Employee(102, "Monu", 60000));
//		empList.add(new Employee(103, "Tonu", 40000));
//		empList.add(new Employee(104, "Ponu", 75000));
//		empList.add(new Employee(105, "Gonu", 55000));
//	}
//
//	public Employee getEmpById(int employeeId) {
//		System.out.println("EmployeeService getEmpById");
////		Employee emp = get data from DB using repository
//		Employee emp = empList.stream().filter(e -> employeeId == e.getEmployeeId()).findAny().orElse(null);
//		if (null == emp)
//			System.out.println("Employee with the id " + employeeId + " not found!");
//		else
//			System.out.println(emp.toString());
//		return emp;
//	}
//
//	public List<Employee> getAllEmps() {
//		System.out.println("EmployeeService getEmpById");
//		return empList;
//	}
//
//	public Employee addEmp(Employee employee) {
//		empList.add(employee);
//		return employee;
//	}
//
//	public Employee updateEmp(Employee employee) {
//		empList.forEach(e -> {
//			if (e.getEmployeeId() == employee.getEmployeeId())
//				empList.set(empList.indexOf(e), employee);
//		});
//		return employee;
//	}
//
//	public Employee deleteEmp(int employeeId) {
//		Employee emp = this.getEmpById(employeeId);
//		empList.forEach(e -> {
//			if (e.getEmployeeId() == employeeId) {
//				empList.remove(e);
//			}
//		});
//		return emp;
//	}
//}
