package com.capgemini.springboot.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Hello {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

//	http://localhost:8088/hello

	@RequestMapping("/hello")
//	@GetMapping("/hello")
	public String hello() {
		LOG.info("Hello");
		return "Hello world!"; // db
	}

//	http://localhost:8088/hi
	@GetMapping("/hi")
	public String hi() {
		LOG.info("Hi");
		return "Hi all!";
	}

}
