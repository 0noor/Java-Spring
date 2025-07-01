package com.luv2code.springboot.thymeleafdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {
	
	//set up logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//set up pointCut declarations 
	@Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
	private void forControllerPackage() {}

	//do the same for service and DAO
	@Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		// Display method we are calling
		String theMethod =  theJoinPoint.getSignature().toShortString();
		myLogger.info("=======>> in @Before: calling method:  "  + theMethod);
		
		//Display the arguments to the method
		
		//Get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		//loop through display args 
		for(Object tempArgs : args ) {
			
			myLogger.info("========>> arguments:" + tempArgs);
			
		}
		
	}
	
	//add @AfterReturning advice
	@AfterReturning(
				pointcut = "forAppFlow()",
				returning ="theResult"
			)
	private void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		// display method we are returning from
		String theMethod =  theJoinPoint.getSignature().toShortString();
		myLogger.info("=======>> in @AfterReturning: calling method:  "  + theMethod);
		
		
		// display data
		myLogger.info("======>> Result:" + theResult);
		
	}
	



}
