package com.capgemini.springboot.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springboot.demo.exception.DepartmentNotFoundException;
import com.capgemini.springboot.demo.exception.NotAuthorizedException;
import com.capgemini.springboot.demo.model.Department;
import com.capgemini.springboot.demo.model.Role;
import com.capgemini.springboot.demo.repository.DepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private AppUserService appUserService;

	@Override
	public List<Department> getAllDepts() {
		if (appUserService.loggedInUser != null || appUserService.loggedInUser.getRole().equals(Role.ADMIN)) {
			List<Department> depList = departmentRepository.findAll();
			if (depList.isEmpty()) {
				String exceptionMessage = "Departments don't exist in the database.";
				LOG.warn(exceptionMessage);
				throw new DepartmentNotFoundException(exceptionMessage);
			} else {
				LOG.info("depList returned successfully.");
				return depList;
			}
		} else {
			String exceptionMessage = "You are not authorised to access this resource!";
			LOG.warn(exceptionMessage);
			throw new NotAuthorizedException(exceptionMessage);
		}
	}

	@Override
	public Department getDeptById(int departmentId) {
		Optional<Department> depOptional = departmentRepository.findById(departmentId);
		if (depOptional.isPresent()) {
			LOG.info(depOptional.get().toString());
			return depOptional.get();
		} else {
			String exceptionMessage = "Department with departmentId " + departmentId + " not found!";
			LOG.warn(exceptionMessage);
			throw new DepartmentNotFoundException(exceptionMessage);
		}
	}

	@Override
	public Department addDept(Department department) {
		LOG.info(department.toString());
		return departmentRepository.save(department);
	}

	@Override
	public Department updateDept(Department department) {
		Optional<Department> depOptional = departmentRepository.findById(department.getDepartmentId());
		if (depOptional.isPresent()) {
			LOG.info(depOptional.get().toString());
			return departmentRepository.save(department);
		} else {
			String exceptionMessage = "Department with departmentId " + department.getDepartmentId() + " not found!";
			LOG.warn(exceptionMessage);
			throw new DepartmentNotFoundException(exceptionMessage);
		}
	}

	@Override
	public Department deleteDept(int departmentId) {
		Optional<Department> depOptional = departmentRepository.findById(departmentId);
		if (depOptional.isPresent()) {
			LOG.info(depOptional.get().toString());
			departmentRepository.deleteById(departmentId);
			return depOptional.get();
		} else {
			String exceptionMessage = "Department with departmentId " + departmentId + " not found!";
			LOG.warn(exceptionMessage);
			throw new DepartmentNotFoundException(exceptionMessage);
		}
	}
}
