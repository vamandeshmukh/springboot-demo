package com.capgemini.springboot.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capgemini.springboot.demo.model.AppUser;

public interface IAppUserController {

	public abstract ResponseEntity<List<AppUser>> getAllAppUsers();

	public abstract ResponseEntity<AppUser> register(AppUser appUser);

	public abstract ResponseEntity<AppUser> login(AppUser appUser);

	public abstract ResponseEntity<String> logout(String userName);

	public abstract ResponseEntity<AppUser> updateAppUser(AppUser appUser);
}
