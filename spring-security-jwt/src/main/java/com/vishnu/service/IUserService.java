package com.vishnu.service;

import java.util.Optional;

import com.vishnu.model.User;

public interface IUserService {

	Integer saveUser(User user);
	
	Optional<User> findByUsername(String username);
}
