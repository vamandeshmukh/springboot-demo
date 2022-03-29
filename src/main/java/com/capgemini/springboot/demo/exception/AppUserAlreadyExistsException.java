package com.capgemini.springboot.demo.exception;

public class AppUserAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 4862786405787654481L;

	public AppUserAlreadyExistsException() {
		super();
	}

	public AppUserAlreadyExistsException(String message) {
		super(message);
	}
}
