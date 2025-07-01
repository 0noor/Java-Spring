package com.luv2code.aopdemo.dao;

import java.util.List;

import com.luv2code.aopdemo.Account;

public interface AccountDAO {

	//Add new method: findAccounts()
	
	
	List<Account> findAccounts();

	List<Account> findAccounts(boolean tripWire);
	
	void addAccount(Account theAccount, boolean vipFlag);
	
	boolean doWord();
	
	String getName();
	
	void setName(String name);
	
	String getServiceCode();
	
	void setServiceCode(String serviceCode);
	
	
}
