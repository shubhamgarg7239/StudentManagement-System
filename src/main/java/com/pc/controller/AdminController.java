package com.pc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pc.entity.Student;
import com.pc.entity.User;
import com.pc.exception.StudentException;
import com.pc.exception.UserException;
import com.pc.service.StudentService;
import com.pc.service.UserService;

@RestController
public class AdminController {
	
	@Autowired
	private UserService userService ;
	
	@Autowired
	private StudentService studentService ;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/addAdmin/")
	public User addAdminHandler(@Valid @RequestBody User user, @Valid @RequestBody(required = false) Student student ) throws UserException, StudentException  {
		User addedUser = userService.addUser(user) ;
		if(addedUser.getRole() == "ROLE_NORMAL") {
			student.setName(user.getUserName()) ;
			student.setEmail(user.getEmail()) ;
			studentService.addStudent(student) ;
		}
		return addedUser ;
	}
	
}
