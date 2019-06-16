package com.ibm.users.service;

import com.ibm.users.exception.ApiException;
import com.ibm.users.model.LoginRequest;
import com.ibm.users.model.LoginResponse;
import com.ibm.users.model.User;

public interface UserService {

	public User findUserByEmail(String email);

	public User saveUser(User user);
	
	public LoginResponse validateUser(LoginRequest loginRequest) throws ApiException;

	User findUserById(int id);
}
