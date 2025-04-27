package com.example.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{
	
	// define field for entity manager
	private EntityManager entityManager;
	//inject entity manager using constructor
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
	//implement save method
	
	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
	}


	@Override
	public Student findById(Integer id) {
		
		return entityManager.find(Student.class, id);
	}


	@Override
	public List<Student> findALL() {
		// Create query 
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName desc", Student.class);
		//return query results
		return theQuery.getResultList();
	}


	@Override
	public List<Student> findByLastName(String theLastName) {
		// Create query 
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student Where lastName=:theData", Student.class);
		
		//set query parameter
		theQuery.setParameter("theData", theLastName);
		
		return theQuery.getResultList();
	}


	@Override
	@Transactional
	public void update(Student theStudent) {
		entityManager.merge(theStudent);
	}


	@Override
	@Transactional
	public void delete(Integer id) {
		// retrieve student
		Student theStudent = entityManager.find(Student.class, id);
		
		
		//Delete Student
		entityManager.remove(theStudent);
		
	}


	@Override
	@Transactional
	public int deleteAll() {
		int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
		return numRowsDeleted;
	}

	
	

}
