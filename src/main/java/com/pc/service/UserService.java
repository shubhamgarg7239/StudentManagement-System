package com.pc.service;

import com.pc.entity.User;
import com.pc.exception.UserException;

public interface UserService {
	public User addUser(User user) throws UserException;
}
