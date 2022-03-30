package com.capgemini.springboot.demo.exception;

public class AppUserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8340802823651555367L;

	public AppUserNotFoundException() {
		super();
	}

	public AppUserNotFoundException(String message) {
		super(message);
	}
}
