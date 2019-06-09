package com.ibm.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.users.exception.ApiException;
import com.ibm.users.model.Error;
import com.ibm.users.model.LoginRequest;
import com.ibm.users.model.LoginResponse;
import com.ibm.users.model.User;
import com.ibm.users.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@RequestMapping(value = { "/signup" }, method = RequestMethod.POST)
	public @ResponseBody User createUser(@RequestBody User user) throws ApiException {

		User userExists = userService.findUserByEmail(user.getEmail());

		if (userExists != null) {
			throw new ApiException("API_ERROR", "User Already Exists.");
		}

		return userService.saveUser(user);
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public @ResponseBody LoginResponse createUser(@RequestBody LoginRequest loginRequest) throws ApiException {

		// Validate Login request

		if (loginRequest != null
				&& (StringUtils.isEmpty(loginRequest.getEmail()) && StringUtils.isEmpty(loginRequest.getPassword()))) {
			throw new ApiException("API_ERROR", "Please provide User Email & Password.");
		}
		return userService.validateUser(loginRequest);
	}

}