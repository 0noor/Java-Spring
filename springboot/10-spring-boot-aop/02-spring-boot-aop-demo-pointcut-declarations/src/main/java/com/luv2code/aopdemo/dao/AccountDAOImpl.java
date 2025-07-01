package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.luv2code.aopdemo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

	private String name;
	
	private String serviceCode;
	
	@Override
	public List<Account> findAccounts(boolean tripWire) {
		
		
		if(tripWire) {
			throw new RuntimeException("No Soup For You!!!!!");
		}
		
		
		List<Account> myAccounts = new ArrayList<>() ;
		
		//Create sample accounts
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Breggory", "Platnum");
		Account temp3 = new Account("Luca", "gold");


		
		//add accounts to list
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);

		
		return myAccounts;
	}
	
	@Override
	public List<Account> findAccounts() {
		
		return findAccounts(false);
	}
	
	@Override
	public void addAccount(Account theAccount,boolean vipFlag) {
		
		
		System.out.println(getClass() + " : Doing my DB work: adding an account");
		
	}

	@Override
	public boolean doWord() {
		
		System.out.println(getClass() + " : doWork()");
		return true;
	}
	

	public String getName() {
		System.out.println(getClass() + " : in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + " : in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + " : in getserviceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + " : in setServiceCode()");
		this.serviceCode = serviceCode;
	}

	


	
	

}
