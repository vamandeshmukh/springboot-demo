package com.capgemini.springboot.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootDemoApplication {

	private static final Logger LOG = LoggerFactory.getLogger(SpringbootDemoApplication.class);

	public static void main(String[] args) {
		LOG.info("Start");
		SpringApplication.run(SpringbootDemoApplication.class, args);
		LOG.info("End");
	}

}
