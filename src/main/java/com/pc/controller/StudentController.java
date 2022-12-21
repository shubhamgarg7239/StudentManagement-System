package com.pc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pc.entity.Course;
import com.pc.entity.Student;
import com.pc.entity.DTOs.StudentDTO;
import com.pc.entity.DTOs.UpdateStudentDTO;
import com.pc.exception.StudentException;
import com.pc.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService ;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/addStudent/")
	public ResponseEntity<Student> addStudentHandler( @RequestBody Student student ) throws StudentException{
		 Student addedStudent = studentService.addStudent(student) ;
		 
		 return new ResponseEntity<Student>(addedStudent, HttpStatus.OK) ;
	}
	
	@PreAuthorize("hasRole('NORMAL')")
	@PatchMapping("/updateProfile/{studentCode}")
	public ResponseEntity<Student> updateProfileHandler(@RequestBody StudentDTO studentDto, @RequestBody UpdateStudentDTO profile ) throws StudentException{
		 Student updatedProfile = studentService.updateProfile(studentDto, profile);
		 
		 return new ResponseEntity<Student>(updatedProfile, HttpStatus.OK) ;
	}
	
	@PreAuthorize("hasRole('NORMAL')")
	@GetMapping("/search/courses/{studentCode}/")
	public ResponseEntity<List<Course>> searchCoursesHandler(@PathVariable Integer studentCode ) throws StudentException{
		 List<Course> courseList = studentService.findCourses(studentCode) ;
		 
		 return new ResponseEntity<List<Course>>(courseList, HttpStatus.OK) ;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/search/{studentName}/")
	public ResponseEntity<List<Student>> searchByNameHandler(@PathVariable String name) throws StudentException{
		 List<Student> studentList = studentService.findByName(name);
		 
		 return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK) ;
	}
	
	@PreAuthorize("hasRole('NORMAL')")
	@DeleteMapping("/delete/courses/{courseId}")
	public ResponseEntity<Student> leaveCoursesHandler(@RequestBody StudentDTO studentDto ,@PathVariable Integer courseId) throws StudentException {
		 Student student = studentService.leaveACourse(studentDto, courseId) ;
		 
		 return new ResponseEntity<Student>(student, HttpStatus.OK) ;
	}
	
	

}
