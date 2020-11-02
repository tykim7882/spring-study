package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController{

	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) {
		
		System.out.println("LogoutController) 로그아웃");		
		// 1. 브라우저 연결 세션 강제 종료
		session.invalidate();
		return "login.jsp";
	}

}
