package com.capgemini.springboot.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.capgemini.springboot.demo.model.Department;
import com.capgemini.springboot.demo.service.DepartmentService;

@RestController
@RequestMapping("/dept")
public class DepartmentController implements IDepartmentController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	DepartmentService departmentService;

	@Override
	@GetMapping("/get-all-departments")
	public ResponseEntity<List<Department>> getAllDepartments() {
		LOG.info("get-all-departments");
		return new ResponseEntity<List<Department>>(departmentService.getAllDepts(), HttpStatus.OK);
	}

	@Override
	@GetMapping("/get-department-by-id/{did}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable(name = "did") int departmentId) {
		LOG.info(Integer.toString(departmentId));
		return new ResponseEntity<Department>(departmentService.getDeptById(departmentId), HttpStatus.OK);
	}

	@Override
	@PostMapping("/add-department")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
		LOG.info(department.toString());
		return new ResponseEntity<Department>(departmentService.addDept(department), HttpStatus.CREATED);
	}

	@Override
	@PutMapping("/update-department")
	public ResponseEntity<Department> updateDepartment(@RequestBody Department department) {
		LOG.info(department.toString());
		return new ResponseEntity<Department>(departmentService.updateDept(department), HttpStatus.OK);
	}

	@Override
	@DeleteMapping("/delete-department/{did}")
	public ResponseEntity<Department> deleteDepartment(@PathVariable(name = "did") int departmentId) {
		LOG.info(Integer.toString(departmentId));
		return new ResponseEntity<Department>(departmentService.deleteDept(departmentId), HttpStatus.OK);
	}

}
