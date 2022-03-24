package com.capgemini.springboot.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

//	http://localhost:8088/hello

	//	@RequestMapping("/hello")
	@GetMapping("/hello")
	public String hello() {
		System.out.println("Hello");
		return "Hello world!";  // db 
	}

//	http://localhost:8088/hi
//	@RequestMapping("/hi")
	@GetMapping("/hi")
	public String hi() {
		System.out.println("Hi");
		return "Hi all!";
	}

}
