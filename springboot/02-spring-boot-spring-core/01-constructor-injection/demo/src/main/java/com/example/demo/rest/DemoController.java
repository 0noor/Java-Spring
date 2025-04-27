package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.coach;


@RestController
public class DemoController {
	//define the private field for the dependency injection
	private coach myCoach;
	
	@Autowired
	public DemoController(coach theCoach){
		myCoach = theCoach;
		
	}
	
	@GetMapping("/getdailyworkout")
	public String getDailyWorkout(){
		return myCoach.getDailyWorkout();
	}

}
