package com.luv2code.springboot.demo.demo.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class rest {
	@GetMapping("/")
	public String sayHello(){
		return "Hello World";
	}
}
