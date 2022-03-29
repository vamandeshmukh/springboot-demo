package com.capgemini.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.springboot.demo.model.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, String> {

}
