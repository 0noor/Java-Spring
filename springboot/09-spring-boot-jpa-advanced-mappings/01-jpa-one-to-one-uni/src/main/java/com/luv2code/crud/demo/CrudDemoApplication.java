package com.luv2code.crud.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.crud.demo.dao.AppDAO;
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
				deleteInstructor(appDAO);
		
		};
	}

	private void deleteInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 2;
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
