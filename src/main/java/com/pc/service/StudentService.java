package com.pc.service;

import java.util.List;

import com.pc.entity.Address;
import com.pc.entity.Course;
import com.pc.entity.Student;
import com.pc.entity.DTOs.UpdateStudentDTO;
import com.pc.exception.StudentException;

public interface StudentService {
	public Student addStudent(Student student) throws StudentException ;
	public Student updateProfile(Integer studentCode, UpdateStudentDTO updatedProfile) throws StudentException ;
	
	public Student findByStudentCode(Integer studentCode ) throws StudentException ;
	public List<Student> findByName(String name) throws StudentException ;
	
	public List<Course> findCourses(Integer studentCode) throws StudentException ;
	public Student leaveACourse(Integer studentCode, Integer courseId) throws StudentException ;
	
	public List<Address> addAddress(Address address)  ;
}
