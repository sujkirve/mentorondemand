package com.ibm.users.service;

import com.ibm.users.model.User;

public interface UserService {

	public User findUserByEmail(String email);

	public User saveUser(User user);
}
