package com.pc.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@PreAuthorize("hasRore('ADMIN')")
	@GetMapping("/dum")
	public String dummyHandler() {
		return "Hello, Shubham ji you" ;
	}
}
