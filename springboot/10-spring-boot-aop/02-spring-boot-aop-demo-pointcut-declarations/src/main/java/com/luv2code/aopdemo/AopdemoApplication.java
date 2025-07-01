 package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

import com.luv2code.aopdemo.service.TrafficFortuneService;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO,
											   MembershipDAO theMembershipDAO,
											   TrafficFortuneService theTrafficFortuneService ) {
		
		return  runner -> {
			
			//demoTheBeforeAdvice(theAccountDAO, theMembershipDAO); 
			//demoTheAfterReturningAdvice(theAccountDAO);
			//demoTheAfterThrowingAdvice(theAccountDAO);
			//demoTheAfterAdvice(theAccountDAO);
			//demoTheAroundAdvice(theTrafficFortuneService);
			//demoTheAroundAdviceHandleException(theTrafficFortuneService);
			demoTheAroundAdviceRethowException(theTrafficFortuneService);

			
			
		};
		
	}

	private void demoTheAroundAdviceRethowException(TrafficFortuneService theTrafficFortuneService) {
		
		System.out.println("\n Main Program: demoTheAroundAdviceRethowException");
		
		System.out.println("Calling getFortune()");
		
		boolean tripWire = true; 
		String data = theTrafficFortuneService.getFortune(tripWire);
		
		System.out.println("\n My fortune is: " + data);
		
		System.out.println("Finished");
		
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {
		
		System.out.println("\n Main Program: demoTheAroundAdviceHandleException");
		System.out.println("Calling getFortune()");
		
		boolean tripWire = true; 
		String data = theTrafficFortuneService.getFortune(tripWire);
		
		System.out.println("\n My fortune is: " + data);
		
		System.out.println("Finished");
		
	}

	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {
		
		System.out.println("\n Main Program: demoTheAroundAdvice");
		System.out.println("Calling getFortune()");
		
		String data = theTrafficFortuneService.getFortune();
		
		System.out.println("\n My fortune is: " + data);
		
		System.out.println("Finished");
		
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		
		//Call the method to find accounts
				List<Account> theAccounts = null;
				
				try {
					// add a boolean flag to simulate exception
					boolean tripWire= false;
				    theAccounts= theAccountDAO.findAccounts(tripWire);
				
				}
				
				catch(Exception exc){
					
					System.out.println("\n\n Main Program: ...Caught Exception: " + exc);
					
				}
				
				// display the Accounts
				System.out.println("\n\nMain Program: demoTheAfterReturningAdvice\n ----");
				
				System.out.println(theAccounts + "\n");
		
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
		
		//Call the method to find accounts
		List<Account> theAccounts = null;
		
		try {
			// add a boolean flag to simulate exception
			boolean tripWire= true;
		    theAccounts= theAccountDAO.findAccounts(tripWire);
		
		}
		
		catch(Exception exc){
			
			System.out.println("\n\n Main Program: ...Caught Exception: " + exc);
			
		}
		
		// display the Accounts
		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice\n ----");
		
		System.out.println(theAccounts + "\n");
		
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
		
		//Call the method to find accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();
		
		// display the Accounts
		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice\n ----");
		
		System.out.println(theAccounts + "\n");
		
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO,MembershipDAO theMembershipDAO) {
		
		Account myAccount = new Account();
		
		myAccount.setName("Breg");
		myAccount.setLevel("Platnum");
		
		// Call the business method
		theAccountDAO.addAccount(myAccount,true);
		theAccountDAO.doWord();
		
		//call the account dao getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("Silver");
		
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		
		//call the membership business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();
		
	
		
	}

}
