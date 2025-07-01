package com.luv2code.crud.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.crud.demo.entity.Course;
import com.luv2code.crud.demo.entity.Instructor;
import com.luv2code.crud.demo.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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
		
		//Find associated courses
		List<Course> courses = tempInstructor.getCourses();
		
		// Remove Instructor reference from associated courses
		
		for (Course  tempCourse: courses) {
			
			tempCourse.setInstructor(null); 
			 
		}
		
		//delete instructor
		entityManager.remove(tempInstructor);
		
		
	}

	@Override
	public InstructorDetail findInstructorDetailById(int theId) {
		
		
		return entityManager.find(InstructorDetail.class, theId);
	}

	@Override
	@Transactional
	public void deleteInstructorDetailById(int theId) {
		
		//find instructor detail
		InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);	
		
		
		//remove the associated object reference
		//break bi-directional link
		
		tempInstructorDetail.getInstructor().setInstructorDetail(null);
		
		
		//delete instructor detail
		
		entityManager.remove(tempInstructorDetail);
	}

	@Override
	public List<Course> findCoursesByInstructorId(int theId) {
		
		
		//create query
		TypedQuery<Course> query = entityManager.createQuery(
					"from Course where instructor.id = :data", Course.class);
		
		query.setParameter("data", theId);
		
		//excecute query
		List<Course> courses = query.getResultList();
		
		return courses;
	}

	@Override
	public Instructor findInstructorByIdJoinFetch(int theId) {
		
		//Create query
		
		TypedQuery<Instructor> query = entityManager.createQuery(
				
														"select i from Instructor i "	
														+ "JOIN FETCH i.courses "
														+ "JOIN FETCH i.instructorDetail  "
														+ "where i.id =:data"  , Instructor.class);
		
		query.setParameter("data", theId);
		
		
		//Excecute query
		
		Instructor instructor = query.getSingleResult();
		
		return instructor;
	}
	
	@Transactional
	@Override
	public void update(Instructor tempInstructor) {
		// save data to the database
		
		entityManager.merge(tempInstructor);
		
	}
	
	@Transactional
	@Override
	public void update(Course tempCourse) {
		
		entityManager.merge(tempCourse);
		
	}

	@Override
	public Course findCourseById(int theId) {
		// TODO Auto-generated method stub
		
		return entityManager.find(Course.class, theId);
	}

	@Override
	@Transactional
	public void deleteCourseById(int theId) {
		
		
		//find course
		Course tempCourse = entityManager.find(Course.class, theId);
		
		//delete course
		entityManager.remove(tempCourse);
	}

	@Override
	@Transactional
	public void save(Course theCourse) {
		
		entityManager.persist(theCourse);
		
	}

	@Override
	public Course findCourseAndReviewsBycourseId(int theId) {
		
		//create query
		TypedQuery<Course> query = entityManager.createQuery(
				
				"select c from Course c "
				
				+ "JOIN FETCH c.reviews "
				
				+ "where c.id = :data" , Course.class);
		
		query.setParameter("data", theId);
		
		
		// excecute the query
		
		Course course = query.getSingleResult();
		
		return course;
	}
	
	
}
