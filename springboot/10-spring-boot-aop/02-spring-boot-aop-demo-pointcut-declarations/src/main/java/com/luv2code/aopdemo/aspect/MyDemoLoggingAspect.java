package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
	ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
		
			
			// Print out method we are advising on
			String method = theProceedingJoinPoint.getSignature().toShortString();
			System.out.println("\n=======> Executing @Around on method: " + method);
			
			//Get begin timestamp
			Long begin= System.nanoTime();
			
			//now, lets excecute the method
			Object result = null;
			
			try {
				
				result = theProceedingJoinPoint.proceed();
				
			} catch (Exception exc) {
				//log the exception
				System.out.println(exc.getMessage());
				
				//rethrow exception
				
				throw exc;
			}
			
			//Get end timestamp
			Long end= System.nanoTime();

			//compute duration and display it
			
			long duration = end - begin;
			System.out.println("\n======> Duration: " + duration + " nano seconds");
			return null;	
		
	}
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		// print out which method we are advising on
				String method = theJoinPoint.getSignature().toShortString();
				System.out.println("\n Executing @After (Finally) on method: " + method);
		
	}
	
	@AfterThrowing(
			
				pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
				
				throwing="theExc"
			
			)
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		
		
				// print out which method we are advising on
				String method = theJoinPoint.getSignature().toShortString();
				System.out.println("\n Executing @AfterThrwoing on method: " + method);
				
				//log the exception
				System.out.println("\n EThe Exception Is: " + theExc);

				
		
	}
	
	
	//Add a new advice for @AfterReturning
	@AfterReturning(
			
				pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
				returning="result"
			
			)
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n======> Executing @AfterReturning on method: " + method);
		
		//print out the results of the method call
		System.out.println("\n result is: " + result);
		
		//lets post process the data ... lets modify it
		
		//Convert the account name to uppercase
		convertAccountNamesToUpperCase(result);
		System.out.println("\n result is: " + result);

	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		//Loop through accounts
		
		for(Account tempAccount: result) {
			
		
			
		//get uppercase version of name
			String theUpperName = tempAccount.getName().toUpperCase();
		
		//update the name on the account
		tempAccount.setName(theUpperName);
		
		}
	}
	
	//lets start with an @Before advice
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterOrSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\n======> Excecuting @Before advice on addAccount in the AccountDAO interface");
		
		//Display my method signature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: " + methodSignature);
		
		//display method arguments
		
		//get args
		Object[] args = theJoinPoint.getArgs();
		
		//loop through the arguments
		for (Object tempArgs : args) {
			System.out.println(tempArgs);
			
			if (tempArgs instanceof Account) {
				
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArgs;
				
				System.out.println("account name:" +theAccount.getName());
				System.out.println("account name:" +theAccount.getLevel());

			}
		}
		
	}
	

	


}
