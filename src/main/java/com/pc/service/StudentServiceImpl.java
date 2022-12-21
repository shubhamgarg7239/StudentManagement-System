package com.pc.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pc.entity.Course;
import com.pc.entity.CurrentStudentSession;
import com.pc.entity.Student;
import com.pc.entity.User;
import com.pc.entity.DTOs.UpdateStudentDTO;
import com.pc.exception.StudentException;
import com.pc.exception.UserException;
import com.pc.repositry.CourseDao;
import com.pc.repositry.StudentDao;
import com.pc.repositry.UserDao;

@Service
public class StudentServiceImpl implements StudentService  {
	@Autowired
	private StudentDao studentDao ;
	@Autowired
	private CourseDao courseDao ;
	@Autowired
	private UserDao userDao ;
	@Autowired
	private ModelMapper modelMapper ;
	@Override
	public Student addStudent(Student student) throws StudentException {
		if(student == null) throw new StudentException("Student should not be null") ;
		return studentDao.save(student);
	}
	
	@Override
	public Student updateProfile(Integer studentCode, UpdateStudentDTO updatedProfile) throws StudentException {
		if(updatedProfile == null) throw new StudentException("profile update should not be null") ;
		if(studentCode != updatedProfile.getStudentCode() ) throw new StudentException("Student code should be same"); 
		return dtoToStudent(updatedProfile) ;
	}
	
	
	@Override
	public Student findByStudentCode(Integer studentCode) throws StudentException {
		Optional<Student> student =  studentDao.findById(studentCode) ;
		if(student.isEmpty()) throw new StudentException("Student code is not correcct") ;
		
		return student.get();
	}

	@Override
	public List<Course> findCourses(Integer studentCode) throws StudentException {
		//Changes Required 
		Optional<Student> student =  studentDao.findById(studentCode) ;
		if(student.isEmpty()) throw new StudentException("Student code is not correcct") ;
		
		return student.get().getCourseList();
	}
	
	@Override
	public Student leaveACourse(Integer studentCode, Integer courseId) throws StudentException {
		/// Changes Requires
		
		Optional<CurrentStudentSession> studentSession = curStuSessionDao.findByUuid(studentSessionId) ;
		if(studentSession.isEmpty()) throw new UserException("Student is not login...or session id is incorrect") ;
		
		Optional<Student> student =  studentDao.findById(studentCode) ;
		if(student.isEmpty()) throw new UserException("Student code is not correcct") ;
		
		Optional<Course> course = courseDao.findById(courseId) ;
		if(course.isEmpty()) throw new UserException("course id is not correct")  ;
		
		List<Course> courseList = student.get().getCourseList() ;
		if(courseList.size() ==0) throw new UserException("student does not have anny course yet!");
		
		if(!courseList.remove(course.get())) throw new UserException("does not able to delete course.. try after some time") ;
		
		student.get().setCourseList(courseList); ;
		
		return studentDao.save(student.get()) ;
	}
	
	@Override
	public List<Student> findByName(String name) throws StudentException {
		if(name == null) throw new StudentException("name should not be null") ;
		return studentDao.findByName(name) ;
	}
	

	
	public User dtoToUser(UpdateStudentDTO profile) {
		return  modelMapper.map(profile, User.class) ;
	}
	public Student dtoToStudent(UpdateStudentDTO studentDTO) {
		return modelMapper.map(studentDTO, Student.class) ;
	}
}
