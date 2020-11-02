package com.springbook.biz.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
	
	public LogAdvice(){
		System.out.println("LogAdvice() 객체 생성");
	}
	
	@Pointcut("execution(* com.springbook.biztest..*Impl.*(..))")
	public void allPointCut() {}
	
	@Pointcut("execution(* com.springbook.biztest..*Impl.get*(..))")
	public void getPointCut() {}

	
	@Before("allPointCut()")
	public void printLog() {
		System.out.println("[공통로그] 비지니스 로직 수행 전 동작!!!");
	}
	
	@After("getPointCut()")
	public void printLogGetMethod() {
		System.out.println("[GET처리] 로그입니다 ==============");
	}
	
	
}
