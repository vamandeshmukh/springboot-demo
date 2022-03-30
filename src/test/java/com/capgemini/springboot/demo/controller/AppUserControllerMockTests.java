package com.capgemini.springboot.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.capgemini.springboot.demo.model.AppUser;
import com.capgemini.springboot.demo.model.Role;
import com.capgemini.springboot.demo.service.AppUserService;

@SpringBootTest
public class AppUserControllerMockTests {

	Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AppUserController appUserController;

	@MockBean
	private AppUserService appUserService;

	private static AppUser appUser;

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
		when(appUserService.loginUser(appUser)).thenReturn(appUser); // returns the mock AppUser object

		HttpStatus expected = HttpStatus.OK;
		HttpStatus actual = appUserController.login(appUser).getStatusCode();

		assertEquals(expected, actual);
	}

	@Test
	public void testLoginHeaders() {
		String expected = "[User " + appUser.getUserName() + " logged in successfully.]";
		when(appUserService.loginUser(appUser)).thenReturn(appUser);
		String actual = appUserController.login(appUser).getHeaders().get("message").toString();
		assertEquals(expected, actual);
	}
}
