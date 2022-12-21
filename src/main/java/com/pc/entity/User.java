package com.pc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userID ;
	private String userName ;
	
	@Column(unique = true)
	@Email
	private String email ;
	private String  password ;
	private String role ;
	
	public User(String userName, String email, String password, String role) {
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	
}
