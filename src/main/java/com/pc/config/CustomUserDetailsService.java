package com.pc.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pc.entity.User;
import com.pc.repositry.UserDao;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userRepo ;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user =  userRepo.findByEmail(email)  ;
		if(user.isEmpty()) throw new UsernameNotFoundException("User not found with this details") ;
		return new CustomUserDetails(user.get());
	}
	
}


/*
 * spring Security internally use to load the User Details ;
 */