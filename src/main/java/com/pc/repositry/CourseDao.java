package com.pc.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pc.entity.Course;

@Repository
public interface CourseDao extends JpaRepository<Course, Integer> {

}
