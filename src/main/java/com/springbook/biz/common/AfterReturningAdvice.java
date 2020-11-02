package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserVO;

@Service
@Aspect
public class AfterReturningAdvice {

	
	@AfterReturning(pointcut = "PointcutCommon.getPointCut()", returning = "returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO)returnObj;
			if(user!=null && "Admin".equals(user.getRole())) {
				System.out.println(user.getName() + "(관리자) 로그인! ");
			}
		}
		
		System.out.println("[ 사후처리 ] "+ method +"() 리턴값 "+ returnObj.toString() +"========");
	}
}
