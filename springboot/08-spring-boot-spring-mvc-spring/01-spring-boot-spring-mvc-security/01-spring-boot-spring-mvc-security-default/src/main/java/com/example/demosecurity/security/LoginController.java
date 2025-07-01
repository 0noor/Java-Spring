package com.example.demosecurity.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showMyLogInPage")
	private String showMyLogInPage() {
		
		return "fancy-login";
	}
	
	
	//add request mapping for access-denied
	
	@GetMapping("/access-denied")
	private String showAccessDenied() {
		
		return "access-denied";
	}
	
}
