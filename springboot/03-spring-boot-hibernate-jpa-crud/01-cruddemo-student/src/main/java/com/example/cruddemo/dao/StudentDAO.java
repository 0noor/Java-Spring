package com.example.cruddemo.dao;

import java.util.List;

import com.example.cruddemo.entity.Student;

public interface StudentDAO {
	
	void save(Student theStudent);
	
	Student findById(Integer id);
	
	List<Student> findALL();
	
	List<Student> findByLastName(String theLastName);
	
	void update(Student theStudent);
	
	void delete(Integer id);
	
	int deleteAll();

}
