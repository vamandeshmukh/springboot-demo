package com.capgemini.springboot.demo.exception;

public class AppUserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1077081933318317917L;

	public AppUserNotFoundException() {
		super();
	}

	public AppUserNotFoundException(String message) {
		super(message);
	}
}
