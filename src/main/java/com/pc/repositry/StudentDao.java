package com.pc.repositry;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pc.entity.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {
	public List<Student> findByName(String name) ;
	
	@Query(value= "select * from student where student_Code=? and dob =?", nativeQuery = true)
	public Optional<Student> findByStudentCodeandDob(Integer studentCode, LocalDate dob) ;
}
