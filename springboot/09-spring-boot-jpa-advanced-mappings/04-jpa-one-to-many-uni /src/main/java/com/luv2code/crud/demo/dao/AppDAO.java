package com.luv2code.crud.demo.dao;

import java.util.List;

import com.luv2code.crud.demo.entity.Course;
import com.luv2code.crud.demo.entity.Instructor;
import com.luv2code.crud.demo.entity.InstructorDetail;

public interface AppDAO {
	
	void save(Instructor theInstructor);
	
	Instructor findInstructorById(int theId);
	
	void deleteInstructorById(int theId);
	
	InstructorDetail findInstructorDetailById(int theId); 
	
	void deleteInstructorDetailById(int theId);
	
	List<Course> findCoursesByInstructorId(int theId) ;
	
	Instructor findInstructorByIdJoinFetch(int theId);
	
	void update(Instructor tempInstructor);
	
	void update(Course tempcourse);
	
	Course findCourseById(int theId);
	
	void deleteCourseById(int theId);
	
	void save(Course theCourse);
	
	Course findCourseAndReviewsBycourseId(int theId);

}
