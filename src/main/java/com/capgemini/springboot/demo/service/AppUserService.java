package com.capgemini.springboot.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springboot.demo.exception.AppUserAlreadyExistsException;
import com.capgemini.springboot.demo.exception.AppUserNotFoundException;
import com.capgemini.springboot.demo.model.AppUser;
import com.capgemini.springboot.demo.repository.AppUserRepository;

@Service
public class AppUserService implements IAppUserService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AppUserRepository appUserRepository;

	AppUser loggedInUser;

	@Override
	public List<AppUser> getAllUsers() {
		List<AppUser> userList = appUserRepository.findAll();
		if (userList.isEmpty()) {
			String exceptionMessage = "AppUsers don't exist in the database.";
			LOG.warn(exceptionMessage);
			throw new AppUserNotFoundException(exceptionMessage);
		} else {
			LOG.info("depList returned successfully.");
			return userList;
		}
	}

	@Override
	public AppUser registerUser(AppUser appUser) {
		LOG.info(appUser.toString());
		Optional<AppUser> userOptional = appUserRepository.findById(appUser.getUserName());
		if (userOptional.isEmpty()) {
			return appUserRepository.save(appUser);
		} else {
			String exceptionMessage = "User with userName " + appUser.getUserName() + " already exists.";
			throw new AppUserAlreadyExistsException(exceptionMessage);
		}
	}

	@Override
	public AppUser loginUser(AppUser appUser) {
		LOG.info(appUser.toString());
		Optional<AppUser> userOptional = appUserRepository.findById(appUser.getUserName());
		if (userOptional.isPresent()) {
			if (appUser.equals(userOptional.get())) {
				LOG.info(userOptional.get().toString());
				loggedInUser = appUser;
				return appUser;
			} else {
				String exceptionMessage = "Wrong password!";
				LOG.warn(exceptionMessage);
				throw new AppUserNotFoundException(exceptionMessage);
			}
		} else {
			String exceptionMessage = "Wrong userName!";
			LOG.warn(exceptionMessage);
			throw new AppUserNotFoundException(exceptionMessage);
		}
	}

	@Override
	public String logoutUser(String userName) {
		if (loggedInUser.getUserName().equals(userName)) {

			loggedInUser = null;
			return userName;
		} else {
			String exceptionMessage = "User with userName " + userName + " is not logged in.";
			LOG.warn(exceptionMessage);
			throw new AppUserNotFoundException(exceptionMessage);
		}
	}

	@Override
	public AppUser updateUser(AppUser appUser) {
		Optional<AppUser> userOptional = appUserRepository.findById(appUser.getUserName());
		if (userOptional.isPresent()) {
			LOG.info(userOptional.get().toString());
			return appUserRepository.save(appUser);
		} else {
			String exceptionMessage = "AppUser with userName " + appUser.getUserName() + " not found!";
			LOG.warn(exceptionMessage);
			throw new AppUserNotFoundException(exceptionMessage);
		}
	}
}