package com.springbook.biz.user;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserSeriviceClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService)context.getBean("userService");
		
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test123");
		
		UserVO user = userService.getUser(vo);
		
		if(user == null) {
			System.out.println("로그인 실패");
		}else {
			System.out.println(user.getName() + "님 환영합니다!!");
		}
		
		Date today = new Date(); 
		LocalDateTime ldt = LocalDateTime.ofInstant(today.toInstant(), ZoneId.systemDefault());
		System.out.println(ldt);
				
		context.close();
		
	
	}

}
