package com.pc.entity.DTOs;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
	@NotNull
	private Integer StudentCode ;
	@Email
	private String email ;
	@Valid
	private LocalDate dob ;
}
