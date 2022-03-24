package com.capgemini.springboot.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

//	http://localhost:8088/hello

	@RequestMapping("/hello")
	public String hello() {
		System.out.println("Hello");
		return "Hello world!";
	}
}
