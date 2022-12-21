package com.pc.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetail> UserExceptionHandler(UserException exc, WebRequest req) {
		MyErrorDetail med = new MyErrorDetail(exc.getMessage(), req.getDescription(false), LocalDateTime.now()) ; 
		return new ResponseEntity<MyErrorDetail>(med, HttpStatus.BAD_REQUEST) ;
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetail> ExceptionHandler(Exception exc, WebRequest req) {
		MyErrorDetail med = new MyErrorDetail(exc.getMessage(), req.getDescription(false), LocalDateTime.now()) ; 
		return new ResponseEntity<MyErrorDetail>(med, HttpStatus.BAD_REQUEST) ;
	}
}
