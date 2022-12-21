package com.pc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pc.UserException;
import com.pc.entity.User;
import com.pc.service.UserService;

@RestController
public class AdminController {
	
	@Autowired
	private UserService userService ;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin")
	public String dummyHandler() {
		return "Hello, Shubham welcome you" ;
	}
	@PreAuthorize("hasRole('NORMAL')")
	@GetMapping("/b")
	public String dummyHandler1() {
		return "Hello, Shubham garg create new one welcome you" ;
	}

	@GetMapping("/a")
	public String dummyHandler2() {
		return "Hello, Shubham garg e you" ;
	}
	@GetMapping("/")
	public String dummyHandler3() {
		return "Hello" ;
	}
	@PostMapping("/addAdmin")
	public User addAdminHandler( @RequestBody User user ) throws UserException {
		return userService.addUser(user) ;
	}
	
}
