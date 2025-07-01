package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {

	@Override
	public String getFortune() {
		
		//Simulate a delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//return a fortune
		return "Expect Heavy Traffic This Morning";
	}

	@Override
	public String getFortune(boolean tripWire) {
		
		if (tripWire) {
			throw new RuntimeException("Major Accident! Highway is closed!");
		}
		
		return getFortune();
	}

}
