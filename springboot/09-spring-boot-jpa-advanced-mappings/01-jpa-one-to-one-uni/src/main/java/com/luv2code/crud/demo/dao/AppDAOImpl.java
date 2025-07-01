package com.luv2code.crud.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.crud.demo.entity.Instructor;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


@Repository
public class AppDAOImpl  implements AppDAO{

	
	//Define field for entity manager using constructor injection
	
	private EntityManager entityManager;
	
	
	@Autowired
	public AppDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public void save(Instructor theInstructor) {
			
		entityManager.persist(theInstructor);
		
	}

	@Override
	public Instructor findInstructorById(int theId) {

		 return entityManager.find(Instructor.class, theId);
	
	}

	@Override
	@Transactional
	public void deleteInstructorById(int theId) {
		
		//find instructor
		Instructor tempInstructor = entityManager.find(Instructor.class, theId);
		
		//delete instructor
		entityManager.remove(tempInstructor);
		
		
	}
	
	
}
