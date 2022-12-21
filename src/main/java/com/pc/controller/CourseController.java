package com.pc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pc.entity.Course;
import com.pc.entity.Student;
import com.pc.exception.CourseException;
import com.pc.service.CourseService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService ;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/addCourse")
	public ResponseEntity<Course> addCourseHandler(@RequestBody Course course) throws CourseException{
		Course addedCourse = courseService.addCourse(course) ;
		return new ResponseEntity<Course>(addedCourse, HttpStatus.CREATED) ;
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/assign-course/{studentCode}/{courseId}")
	public ResponseEntity<Student> assignCourseHandler(@PathVariable Integer studentCode , @PathVariable Integer courseId) throws CourseException {
		Student student = courseService.assignCourseToStudent(studentCode, courseId) ;
		
		return new ResponseEntity<Student>(student, HttpStatus.OK) ;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/course/{courseId}/allstudents/")
	public ResponseEntity<List<Student>> getStudentsByCourseHandler( @PathVariable Integer courseId ) throws CourseException{
		List<Student> studentList = courseService.getStudentsByCourse(courseId) ;
		
		return new ResponseEntity<List<Student>>(studentList , HttpStatus.OK) ;	
	}
	
	
	
	@GetMapping("/allCourse/")
	public ResponseEntity<List<Course>> allCourseHandler() throws CourseException{
		List<Course> courseList = courseService.getAllCourse() ;
		
		return new ResponseEntity<List<Course>>(courseList , HttpStatus.OK) ;	
	}
}
