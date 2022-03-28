package com.capgemini.springboot.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException e) {
		String exceptionMessage = e.getMessage();
		LOG.info(exceptionMessage);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", exceptionMessage);
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<Object> handleDepartmentNotFoundException(DepartmentNotFoundException e) {
		String exceptionMessage = e.getMessage();
		LOG.info(exceptionMessage);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", exceptionMessage);
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}
}
