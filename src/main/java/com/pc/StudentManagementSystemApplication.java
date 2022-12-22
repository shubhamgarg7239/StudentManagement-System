package com.pc;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.pc.entity.User;
import com.pc.service.UserService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class StudentManagementSystemApplication implements CommandLineRunner
{
	@Autowired
	private BCryptPasswordEncoder  bcry ;
	@Autowired
	private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
	@Override
	public void run(String... args) throws Exception {
		try {
			User admin = new User( "Paras", "paras@gmail.com", this.bcry.encode("admin@123"), "ADMIN") ;
			
			userService.addUser(admin) ;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
/*
 * User admin = new User() ;
			admin.setUserName("Paras");
			admin.setEmail("paras@gmail.com");
			admin.setPassword(this.bcry.encode("admin@123"));
			admin.setRole("ROLE_ADMIN");
*/
