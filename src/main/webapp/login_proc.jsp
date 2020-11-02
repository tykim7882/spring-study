<%@page import="java.util.List"%>
<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@page import="com.springbook.biz.user.impl.UserDAO"%>
<%@page import="com.springbook.biz.user.UserVO"%>
<%@page contentType="text/html; charset=UTF-8" %>
<%

	// 1. 사용자 입력정보 확인
	String id = request.getParameter("id");
	String password = request.getParameter("password");

	// 2. DB연동 처리
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(password);
	
	UserDAO userDAO = new UserDAO();
	UserVO user = userDAO.getUser(vo);
	
	// 3. 화면 전환
	if(user != null){
		response.sendRedirect("getBoardList.do");
	}else{
		response.sendRedirect("login.jsp");
	}

%>