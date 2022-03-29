package com.capgemini.springboot.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springboot.demo.model.AppUser;
import com.capgemini.springboot.demo.service.AppUserService;

@RestController
@RequestMapping("/user")
public class AppUserController implements IAppUserController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AppUserService appUserService;

	@Override
	@GetMapping("/get-all-users")
	public ResponseEntity<List<AppUser>> getAllAppUsers() {
		LOG.info("get-all-appUsers");
		return new ResponseEntity<List<AppUser>>(appUserService.getAllUsers(), HttpStatus.OK);
	}

	@Override
	@PostMapping("/register")
	public ResponseEntity<AppUser> register(@RequestBody AppUser appUser) {
		LOG.info(appUser.toString());
		return new ResponseEntity<AppUser>(appUserService.registerUser(appUser), HttpStatus.CREATED);
	}

	@Override
	@PostMapping("/login")
	public ResponseEntity<AppUser> login(@RequestBody AppUser appUser) {
		LOG.info(appUser.toString());
		return new ResponseEntity<AppUser>(appUserService.loginUser(appUser), HttpStatus.CREATED);
	}

	@Override
	@GetMapping("/logout/{user}")
	public ResponseEntity<String> logout(@PathVariable(name = "user") String userName) {
		LOG.info(userName);
		return new ResponseEntity<String>(appUserService.logoutUser(userName), HttpStatus.OK);
	}

	@Override
	@PutMapping("/update-user")
	public ResponseEntity<AppUser> updateAppUser(@RequestBody AppUser appUser) {
		LOG.info(appUser.toString());
		return new ResponseEntity<AppUser>(appUserService.updateUser(appUser), HttpStatus.OK);
	}
}
