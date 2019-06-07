package com.ibm.users.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.users.model.User;
import com.ibm.users.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/signup" }, method = RequestMethod.POST)
	public @ResponseBody User createUser(@RequestBody User user) {

		User userExists = userService.findUserByEmail(user.getEmail());

		if (userExists != null) {
			// bindingResult.rejectValue("email", "error.user", "This email already
			// exists!");
		}

		return userService.saveUser(user);
	}

}