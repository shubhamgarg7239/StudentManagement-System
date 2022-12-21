package com.pc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pc.entity.Course;
import com.pc.entity.Student;
import com.pc.exception.CourseException;
import com.pc.repositry.CourseDao;
import com.pc.repositry.StudentDao;

@Service
public class CoursesServiceImpl implements CourseService {
	@Autowired
	private CourseDao courseDao ;
	
	@Autowired
	private StudentDao studentDao ;
	
	@Override
	public Course addCourse(Course course) throws CourseException  {
		if(course ==null) throw new CourseException("course detail should not be null") ;
		return courseDao.save(course); 
	}

	@Override
	public Student assignCourseToStudent(Integer studentCode, Integer courseId) throws CourseException {
		
		Optional<Student> student = studentDao.findById(studentCode) ;
		if(student.isEmpty()) throw new CourseException("Student code is not correct")  ;
		
		Optional<Course> course = courseDao.findById(courseId) ;
		if(course.isEmpty()) throw new CourseException("course id is not correct")  ;
		
		List<Course> courseList = student.get().getCourseList() ;
		courseList.add(course.get()) ;
		student.get().setCourseList(courseList);
		
		return studentDao.save(student.get()) ;
	}

	@Override
	public List<Student> getStudentsByCourse(Integer courseId) throws CourseException {
		
		Optional<Course> course = courseDao.findById(courseId) ;
		if(course.isEmpty()) throw new CourseException("course id is not correct")  ;
		
		List<Student> studentList = course.get().getStudentList() ;
		if(studentList.size() == 0) throw new CourseException("No student added till in this course") ;
		
		return studentList;
	}

	@Override
	public List<Course> getAllCourse() {
		return courseDao.findAll() ;
	}

}
