package com.luv2code.crud.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.crud.demo.dao.AppDAO;
import com.luv2code.crud.demo.entity.Course;
import com.luv2code.crud.demo.entity.Instructor;
import com.luv2code.crud.demo.entity.InstructorDetail;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(CrudDemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO ) {
		return runner -> {

				//createInstructor(appDAO);
				//findInstructor(appDAO);
				//deleteInstructor(appDAO);
				//findInstructorDetail(appDAO);
				//deleteInstructorDetail(appDAO);
				//createInstructorWithCourses(appDAO);
				//findInstructorWithCourses(appDAO);
				//findCoursesForInstructor(appDAO);
				//findInstructorWithCoursesJoinFetch(appDAO);
				//updateInstructor(appDAO);
				//updateCourse(appDAO);
				//deleteInstructor(appDAO);
				deleteCourse(appDAO);
			
		
		};
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;
		
		System.out.println("Deleting course id: " + theId);
		
		appDAO.deleteCourseById(theId);
		
		System.out.println("Done!");
		
	}

	private void updateCourse(AppDAO appDAO) {
		 int theId = 10;
		 
		 //find course
		 
		 System.out.println("Finding course id: " + theId);
		 Course tempCourse = appDAO.findCourseById(theId);
		 
		 //update the course
		 System.out.println("Updating course id: " + theId);
		 tempCourse.setTitle("Enjoy the simple things");
		 
		 appDAO.update(tempCourse);
		 
		 System.out.println("Done!");
		
	}

	private void updateInstructor(AppDAO appDAO) {
		
		int theId = 1;
		
		// find instructor
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		
		//update the instructor
		 System.out.println("Updating instructor id: " + theId); 
		 
		 tempInstructor.setLastName("Tester");
		 
		 appDAO.update(tempInstructor);
		 
		 System.out.println("Done!");
		
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		
		
		int theId = 1;
		
		// find the instructor
		
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		
		System.out.println("tempInstructor: " + tempInstructor );
		
		System.out.println("the associated courses: "  + tempInstructor.getCourses());
		
		System.out.println("DONE"); 
		
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor with id: " + theId);
		
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		
		System.out.println("tempInstructor: " + tempInstructor);
		
		System.out.println("Finding courses for instructor id: " + theId);
		
		List<Course> courses= 	appDAO.findCoursesByInstructorId(theId);
		
		//associate the objects
		tempInstructor.setCourses(courses);
		
		System.out.println("The associated courses: " + tempInstructor.getCourses());
		
		System.out.println("Done!");
		
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		
		int theId = 1;
		System.out.println("Finding instructor with id: " + theId);
		
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		
		System.out.println("tempInstructor: " + tempInstructor);
		
		System.out.println("The associated courses: " + tempInstructor.getCourses());
		
		System.out.println("Done!");


		
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		///create the instructor 
		Instructor tempInstructor = new Instructor("Susan","Public","SusanP@gmail.com");
				
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com/susanPx", "Video Games");
		
		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		
		//create some course
		
		Course tempCourse1 = new Course("Air guitar-the ultimate guide");
		
		Course tempCourse2 = new Course("Pinball master class");
		
		//add courses to the instructor
		
		tempInstructor.add(tempCourse1);
		
		tempInstructor.add(tempCourse2);
		
		//save the instructor
		//
		//NOTE: this will also save the courses
		
		System.out.println("Saving Instructor: " + tempInstructor);
		System.out.println("The course: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor); 

		System.out.println("Done");
		
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
			
		
		int theId = 5;
		
		System.out.println("Deleting Instructor details id: " + theId);
		
		appDAO.deleteInstructorDetailById(theId);
		
		System.out.println("Done");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		
		int theId=3 ;
		
		// find instructor detail
		
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
		
		//print instructor detail
		System.out.println("tempInstructorDetail: "+tempInstructorDetail);
		
		//print the associated instructor
		
		System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());
		
		
		System.out.println("Done!");
		
	}

	private void deleteInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 1;
		System.out.println("Deleting instructor id: "  + theId);
		
		appDAO.deleteInstructorById(theId);
		
		System.out.println("Done!");
		
	}

	private void findInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		
		int theId = 2;
		
		System.out.println("Finding Instructor id:" + theId);
		
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associate instructorDetail only: " +tempInstructor.getInstructorDetail());
		
	}

	private void createInstructor(AppDAO appDAO) {
		
		/*//create the instructor 
		Instructor tempInstructor = new Instructor("Cha","Cha-Slide","chachaslide@gmail.com");
		
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Loves to fish");
		*/
		
		//create the instructor 
		Instructor tempInstructor = new Instructor("Madhu","Patel","MahduPatel@gmail.com");
				
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Playing the Sitar");
		
		
		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		
		//save the instructor
		//
		//This will also save the instructor details due to CascadeType.all
		//
		System.out.println("Saving Instructor: " + tempInstructor);
		
		appDAO.save(tempInstructor);
		
		System.out.println("Done!!");
	}

}
