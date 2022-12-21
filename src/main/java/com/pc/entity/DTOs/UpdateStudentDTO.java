package com.pc.entity.DTOs;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.pc.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStudentDTO {
	private Integer studentCode ;
	private String name;
	private  LocalDate dob;
	private  Gender gender ;
	
	@Email(message = "email should be in proper condition")
	private String email ;
	
	@Size(min =10, max = 10, message = "mob no should be in 10 digit")
	private String mobNo ;
	
	private String parentName ;
}
