package com.capgemini.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		System.out.println("Start");
		SpringApplication.run(SpringbootDemoApplication.class, args);
		System.out.println("End");
	}

}
