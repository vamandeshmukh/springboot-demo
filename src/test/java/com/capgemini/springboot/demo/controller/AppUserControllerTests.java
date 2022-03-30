package com.capgemini.springboot.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.capgemini.springboot.demo.model.AppUser;
import com.capgemini.springboot.demo.model.Role;

@SpringBootTest
public class AppUserControllerTests {

	Logger LOG = LoggerFactory.getLogger(this.getClass());

	private static AppUser appUser;

	@Autowired
	AppUserController appUserController;

	@BeforeAll
	public static void setUp() {
		appUser = new AppUser("vaman", "vaman", Role.ADMIN);
	}

	@AfterAll
	public static void tearDown() {
		appUser = null;
	}

	@Test
	public void testLoginHttpStatus() {
		HttpStatus expected = HttpStatus.OK;
		HttpStatus actual = appUserController.login(appUser).getStatusCode();
		assertEquals(expected, actual);
	}

	@Test
	public void testLoginHeaders() {
		String expected = "[User " + appUser.getUserName() + " logged in successfully.]";
		String actual = appUserController.login(appUser).getHeaders().get("message").toString();
		assertEquals(expected, actual);
	}

}
