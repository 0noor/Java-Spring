package com.example.demo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements coach {

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		
		return "Practice fast bowling for 15 mins!!!!";
	}

	
}
