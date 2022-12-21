package com.pc.service;

import java.util.List;

import com.pc.entity.Course;
import com.pc.entity.Student;
import com.pc.entity.DTOs.StudentDTO;
import com.pc.entity.DTOs.UpdateStudentDTO;
import com.pc.exception.StudentException;

public interface StudentService {
	public Student addStudent(Student student) throws StudentException ;
	public Student updateProfile(StudentDTO studentDto, UpdateStudentDTO updatedProfile) throws StudentException ;
	
	public Student findByStudentCode(Integer studentCode ) throws StudentException ;
	public List<Student> findByName(String name) throws StudentException ;
	
	public List<Course> findCourses(Integer studentCode) throws StudentException ;
	public Student leaveACourse(StudentDTO studentDto, Integer courseId) throws StudentException ;
	
	public Student addAddress(Integer studentCode , Integer addressId) throws StudentException ;
}
