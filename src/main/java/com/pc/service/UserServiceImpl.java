package com.pc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pc.entity.User;
import com.pc.exception.UserException;
import com.pc.repositry.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userRepo ;

	@Override
	public User addUser(User user) throws UserException {
		if(user == null) throw new UserException("User shold not be null") ;
		
		if(user.getRole() == null) user.setRole("ROLE_" + "NORMAL");
		else user.setRole("ROLE_" + user.getRole());
		
		return userRepo.save(user) ;
	}

}
