package com.pc.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyErrorDetail {
	private  String message ;
	private  String description ;
	private LocalDateTime timeStamp ;
}
