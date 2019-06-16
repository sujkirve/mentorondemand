package com.ibm.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ibm.users.exception.ApiException;
import com.ibm.users.model.Error;
import com.ibm.users.model.LoginRequest;
import com.ibm.users.model.LoginResponse;
import com.ibm.users.model.Role;
import com.ibm.users.model.User;
import com.ibm.users.repository.RoleRespository;
import com.ibm.users.repository.UserRepository;
import java.util.Arrays;
import java.util.HashSet;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRespository roleRespository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User findUserById(int id) {
		return userRepository.findById(id);
	}
	
	@Override
	public User saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Role userRole = roleRespository.findByRole("ADMIN");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		return userRepository.save(user);
	}

	public LoginResponse validateUser(LoginRequest loginRequest) throws ApiException {
		LoginResponse loginResponse = new LoginResponse();

		// Fetch user record
		User userExists = this.findUserByEmail(loginRequest.getEmail());

		if (userExists == null) {
			throw new ApiException("API_ERROR", "User Not Found.");
		}

		if (bCryptPasswordEncoder.matches(loginRequest.getPassword(), userExists.getPassword())) {
			loginResponse.setUser(userExists);
		} else {
			Error error = new Error("API_ERROR", "User Authentication Failed.");
			loginResponse.getErrors().add(error);
		}
		return loginResponse;
	}

}
