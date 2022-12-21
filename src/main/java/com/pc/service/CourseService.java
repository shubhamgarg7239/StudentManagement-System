package com.pc.service;

import java.util.List;

import com.pc.entity.Course;
import com.pc.entity.Student;
import com.pc.exception.CourseException;

public interface CourseService {
	public Course addCourse(Course course) throws CourseException  ;
	public Student assignCourseToStudent(Integer studentCode, Integer courseId) throws CourseException ;
	public List<Student> getStudentsByCourse(Integer courseId) throws CourseException ;
	
	public List<Course> getAllCourse() ;
}
