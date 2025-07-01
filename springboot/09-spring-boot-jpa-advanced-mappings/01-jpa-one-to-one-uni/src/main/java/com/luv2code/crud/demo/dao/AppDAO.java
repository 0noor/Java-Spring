package com.luv2code.crud.demo.dao;

import com.luv2code.crud.demo.entity.Instructor;

public interface AppDAO {
	
	void save(Instructor theInstructor);
	
	Instructor findInstructorById(int theId);
	
	void deleteInstructorById(int theId);

}
