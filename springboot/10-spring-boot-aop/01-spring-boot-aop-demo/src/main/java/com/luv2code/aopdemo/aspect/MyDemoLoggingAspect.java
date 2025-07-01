package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//This is where we add all of our related advices for logging
	
	//lets start with an @Before advice
	
	@Before("execution( * com.luv2code.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n====>>> Excecuting @Before advice on addAccount in the AccountDAO interface\n");
		
	}

}
