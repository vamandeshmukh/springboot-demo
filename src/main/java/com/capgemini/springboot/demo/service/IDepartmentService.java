package com.capgemini.springboot.demo.service;

import java.util.List;

import com.capgemini.springboot.demo.model.Department;

public interface IDepartmentService {

	public abstract List<Department> getAllDepts();

	public abstract Department getDeptById(int departmentId);

	public abstract Department addDept(Department department);

	public abstract Department updateDept(Department department);

	public abstract Department deleteDept(int departmentId);

}
