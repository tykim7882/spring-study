<%@ page contentType="text/html; charset=UTF-8"%>
<%
	// 1. 브라우저 연결 세션 강제 종료

	session.invalidate();

	// 2. 세션 종료 후 메인화면 이동
	response.sendRedirect("login.jsp");
%>