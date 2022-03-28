package com.capgemini.springboot.demo.repository;

import java.util.List;

//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.springboot.demo.model.Employee;

//docs - https://docs.spring.io/spring-data/jpa/docs/current/reference/html/

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
//public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {

//	public abstract List<Employee> findByFieldName(String fieldName); // syntax

	public abstract List<Employee> findByFirstName(String firstName); // valid

//	public abstract List<Employee> findBySalary(double salary); // valid

	// SQL, JPQL, HQL

//	@Query("SELECT e FROM Employee e WHERE salary = ?1")
//	public abstract List<Employee> findBySalary(double salary); // valid

	@Query("SELECT e FROM Employee e WHERE salary = ?1")
	public abstract List<Employee> findBySalary(double salary); // valid

	public abstract List<Employee> findBySalaryGreaterThan(double salary); // valid

	public abstract List<Employee> findBySalaryLessThan(double salary); // valid

	public abstract List<Employee> findBySalaryBetween(double salary, double salary2); // valid

	// public abstract List<Employee> findByLastName(String lastName); // not valid

	// public abstract List<Employee> findByAnyOtherNameNotAField(String
	// blahBlahBlah); // not valid
}
