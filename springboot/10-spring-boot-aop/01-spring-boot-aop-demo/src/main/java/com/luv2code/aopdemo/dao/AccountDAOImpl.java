package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

import com.luv2code.aopdemo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

	@Override
	public void addAccount(Account theAccount,boolean vipFlag) {
		
		
		System.out.println(getClass() + " : Doing my DB work: adding an account");
		
	}

	@Override
	public boolean doWord() {
		
		System.out.println(getClass() + " : doWork()");
		return true;
	}

}
