package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {

	//This is where we add all of our related advices for logging
	
	
	//Pointcut expression to create a future shorthand
	
	@Pointcut("execution( * com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	//Pointcut for getter methods
	@Pointcut("execution( * com.luv2code.aopdemo.dao.*.get*(..))")
	public void getterMethods() {}
	
	//Pointcut for setter methods
	@Pointcut("execution( * com.luv2code.aopdemo.dao.*.set*(..))")
	public void setterMethods() {}
	
	//create pointcut include package exclude getter or setter
	@Pointcut("forDaoPackage() && !(getterMethods() || setterMethods())")
	public void forDaoPackageNoGetterOrSetter() {}
	

}
