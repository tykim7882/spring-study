package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {

	@Around("PointcutCommon.getPointCut()")
	public Object aroudLog(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("[Around) BEFORE] 비지니스 메소드 수행 전 처리내용 ====");
		
		String method = pjp.getSignature().getName();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		// business method
		Object returnObj = pjp.proceed();
		
		stopWatch.stop();
		
		System.out.println("[Around) AFTER] "+method+"() 비지니스 메소드 수행 시 걸린 시간 : "
				+ stopWatch.getTotalTimeMillis() + "(ms)초");
		return returnObj;
	}
}
