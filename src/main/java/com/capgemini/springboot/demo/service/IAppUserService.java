package com.capgemini.springboot.demo.service;

import java.util.List;

import com.capgemini.springboot.demo.model.AppUser;

public interface IAppUserService {

	public abstract List<AppUser> getAllUsers();

	public abstract AppUser registerUser(AppUser appUser);

	public abstract AppUser loginUser(AppUser appUser);

	public abstract AppUser updateUser(AppUser appUser);

	public abstract AppUser deleteUser(String userName);

}
