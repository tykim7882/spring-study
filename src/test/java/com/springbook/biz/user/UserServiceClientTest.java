package com.springbook.biz.user;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClientTest {

	AbstractApplicationContext context;

	@Before
	public void setApplicationContext() {

		context = new GenericXmlApplicationContext("applicationContext.xml");
	}

	@After
	public void closeApplicationContext() {
		context.close();
	}

	@Test
	public void getUserTest() {

		UserService service = (UserService) context.getBean("userService");

		// 성공 테스트
		UserVO vo1 = new UserVO();
		vo1.setId("usesr1");
		vo1.setPassword("user1");

		UserVO user1 = service.getUser(vo1);
		assertThat(user1.getName(), is("홍길동"));
		assertThat(user1.getName(), not("홍길동2"));

		// 실패 테스트
		UserVO vo2 = new UserVO();
		vo2.setId("test");
		vo2.setPassword("test12");

		UserVO user2 = service.getUser(vo2);
		assertThat(user2, nullValue());
		
	}
}
