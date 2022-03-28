package com.capgemini.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.springboot.demo.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
