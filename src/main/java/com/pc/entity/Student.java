package com.pc.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pc.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer studentCode ;
	private String name;
	@NotNull
	private  LocalDate dob;
	private  Gender gender ;
	
	@Email(message = "email should be in proper condition")
	private String email ;
	
	@Size(min =10, max = 10, message = "mob no should be in 10 digit")
	private String mobNo ;
	
	private String parentName ;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<Address> address = new ArrayList<Address>() ;
	
	@ManyToMany(cascade = CascadeType.ALL)
	List<Course> courseList = new ArrayList<Course>() ;
}
