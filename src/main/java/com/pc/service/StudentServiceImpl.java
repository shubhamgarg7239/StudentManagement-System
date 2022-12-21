package com.pc.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pc.entity.Address;
import com.pc.entity.Course;
import com.pc.entity.Student;
import com.pc.entity.User;
import com.pc.entity.DTOs.StudentDTO;
import com.pc.entity.DTOs.UpdateStudentDTO;
import com.pc.exception.StudentException;
import com.pc.repositry.AddressDao;
import com.pc.repositry.CourseDao;
import com.pc.repositry.StudentDao;

@Service
public class StudentServiceImpl implements StudentService  {
	@Autowired
	private StudentDao studentDao ;
	@Autowired
	private CourseDao courseDao ;
	@Autowired
	private AddressDao addressDao ;
	@Autowired
	private ModelMapper modelMapper ;
	@Override
	public Student addStudent(Student student) throws StudentException {
		if(student == null) throw new StudentException("Student should not be null") ;
		return studentDao.save(student);
	}
	
	@Override
	public Student updateProfile(StudentDTO studentDto, UpdateStudentDTO updatedProfile) throws StudentException {
		if(updatedProfile == null) throw new StudentException("profile update should not be null") ;
		
		if(studentDto.getStudentCode() != updatedProfile.getStudentCode() ) throw new StudentException("Student code should be same");
		validateStudent(studentDto) ;
		Student newStudent = dtoToStudent(updatedProfile) ;
		
		return studentDao.save(newStudent) ;
	}
	
	
	@Override
	public Student findByStudentCode(Integer studentCode) throws StudentException {
		Optional<Student> student =  studentDao.findById(studentCode) ;
		if(student.isEmpty()) throw new StudentException("Student code is not correcct") ;
		
		return student.get();
	}

	@Override
	public List<Course> findCourses(Integer studentCode) throws StudentException {
		Student student = findByStudentCode(studentCode) ;
		
		return student.getCourseList();
	}
	
	@Override
	public Student leaveACourse(StudentDTO studentDto, Integer courseId) throws StudentException {
		
		Student student =  validateStudent(studentDto) ;
		
		Optional<Course> course = courseDao.findById(courseId) ;
		if(course.isEmpty()) throw new StudentException("course id is not correct")  ;
		
		
		List<Course> courseList = student.getCourseList() ;
		if(courseList.size() ==0) throw new StudentException("student does not have anny course yet!");
		
		if(!courseList.remove(course.get())) throw new StudentException("does not able to delete course.. try after some time") ;
		
		student.setCourseList(courseList); 
		
		return studentDao.save(student) ;
	}
	
	@Override
	public List<Student> findByName(String name) throws StudentException {
		if(name == null) throw new StudentException("name should not be null") ;
		return studentDao.findByName(name) ;
	}

	@Override
	public Student addAddress(Integer studentCode, Integer addressId) throws StudentException {
		Student student = findByStudentCode(studentCode) ;
		List<Address> addressList = student.getAddress() ;
		
		Optional<Address> address = addressDao.findById(addressId) ;
		if(address.isEmpty()) throw new StudentException("adress should not be null") ;
		
		addressList.add(address.get()) ;
		student.setAddress(addressList);
		
		return studentDao.save(student) ;
	}
	
	public Student validateStudent(StudentDTO studentDto) throws StudentException {
		Optional<Student> student =  studentDao.findByStudentCodeandDob(studentDto.getStudentCode(), studentDto.getDob()) ;
		if(student.isEmpty()) throw new StudentException("student details not correct") ;
		return student.get() ;
	}
	
	public User dtoToUser(UpdateStudentDTO profile) {
		return  modelMapper.map(profile, User.class) ;
	}
	public Student dtoToStudent(UpdateStudentDTO studentDTO) {
		return modelMapper.map(studentDTO, Student.class) ;
	}
}
