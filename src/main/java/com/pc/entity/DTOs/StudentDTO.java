package com.pc.entity.DTOs;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
	private Integer StudentCode ;
	private String email ;
	private LocalDate dob ;
}
