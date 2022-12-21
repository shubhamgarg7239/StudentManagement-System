package com.pc.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
 	private Integer courseId ;
	private String courseName ;
	private String description ;
	private String courseType ; 
	private LocalDate duration ;
	
	private String topics ;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy= "courseList")
	@JsonIgnore
	List<Student> studentList = new ArrayList<>() ;
	
}
