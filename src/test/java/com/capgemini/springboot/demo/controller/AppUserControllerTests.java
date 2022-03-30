package com.capgemini.springboot.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.capgemini.springboot.demo.model.AppUser;
import com.capgemini.springboot.demo.model.Role;
import com.capgemini.springboot.demo.service.AppUserService;

@SpringBootTest
public class AppUserControllerTests {

	Logger LOG = LoggerFactory.getLogger(this.getClass());

//	private static ResponseEntity<AppUser> appUserResponse;
	private static AppUser appUser;

	@Autowired
	AppUserController appUserController;

	@BeforeAll
	public static void setUp() {
		appUser = new AppUser("vaman", "vaman", Role.ADMIN);

	}

	@Test
	public void testLoginHttpStatus() {
		HttpStatus expected = HttpStatus.OK;
		HttpStatus actual = appUserController.login(appUser).getStatusCode();
		LOG.info(expected.toString());
		LOG.info(actual.toString());
		assertEquals(expected, actual);
	}

	@Test
	public void testLoginHeaders() {
		String expected = "abcd";
		String actual = appUserController.login(appUser).getHeaders().get("message").toString();
		LOG.info(expected.toString());
		LOG.info(actual.toString());
		assertEquals(expected, actual);
	}
}
