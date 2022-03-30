package com.capgemini.springboot.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.springboot.demo.model.AppUser;
import com.capgemini.springboot.demo.model.Role;

@SpringBootTest
public class AppUserServiceTests {

	Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
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
	public void testLogin() {
		LOG.info(appUser.toString());
		AppUser expected = appUser;
		AppUser actual = appUserService.loginUser(appUser);
		assertEquals(expected, actual);
	}

//	@Disabled
	@Test
	public void testLoginFailure() {
		LOG.info(appUser.toString());
		AppUser unexpected = appUser;
		AppUser actual = appUserService.loginUser(new AppUser("Sonu", "Sonu", Role.EMPLOYEE));
		assertNotEquals(unexpected, actual);
	}
}
