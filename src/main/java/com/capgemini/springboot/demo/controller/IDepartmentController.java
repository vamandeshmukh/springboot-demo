package com.capgemini.springboot.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capgemini.springboot.demo.model.Department;

public interface IDepartmentController {

	public abstract ResponseEntity<List<Department>> getAllDepartments();

	public abstract ResponseEntity<Department> getDepartmentById(int departmentId);

	public abstract ResponseEntity<Department> addDepartment(Department department);

	public abstract ResponseEntity<Department> updateDepartment(Department department);

	public abstract ResponseEntity<Department> deleteDepartment(int departmentId);

}
