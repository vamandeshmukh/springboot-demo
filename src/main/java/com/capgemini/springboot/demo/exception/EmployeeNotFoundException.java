package com.capgemini.springboot.demo.exception;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7785319514348566676L;

	public EmployeeNotFoundException() {
		super();
	}

	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
