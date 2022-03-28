package com.capgemini.springboot.demo.exception;

public class DepartmentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7562994017446246010L;

	public DepartmentNotFoundException() {
		super();
	}

	public DepartmentNotFoundException(String message) {
		super(message);
	}
}
