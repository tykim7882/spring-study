<%@ page import="java.util.List"%>
<%@ page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@ page import="com.springbook.biz.board.BoardVO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
</head>
<body>
	<center>
		<h1><spring:message code="message.board.list.mainTitle"/></h1>
		<h3>
			${userName}<spring:message code="message.board.list.welcomeMsg"/><a href="logout.do">LogOut</a>
		</h3>

		<!-- 검색 -->
		<form action="getBoardList.do" method="post">
			<table border="1" cellpadding="0" cellspacing-="0" width="700">
				<tr align="right">
					<td>
						<select name="searchCondition">
							<c:forEach var="condition" items="${conditionMap}" >
								<option value="${condition.value}">${condition.key}</option>
							</c:forEach>							
						</select>
						<input name="searchKeyword" type="text" />
						<input type="submit" value="<spring:message code="message.board.list.search.condition.btn"/>"/>
					</td>
				</tr>
			</table>
		</form>

		<table border="1" cellpadding="0" cellspacing-="0" width="700">
			<tr>
				<th style="backgrond-color: orange;" width="100"><spring:message code="message.board.list.table.head.seq"/></th>
				<th style="backgrond-color: orange;" width="200"><spring:message code="message.board.list.table.head.title"/></th>
				<th style="backgrond-color: orange;" width="150"><spring:message code="message.board.list.table.head.writer"/></th>
				<th style="backgrond-color: orange;" width="150"><spring:message code="message.board.list.table.head.regDate"/></th>
				<th style="backgrond-color: orange;" width="100"><spring:message code="message.board.list.table.head.cnt"/></th>
			</tr>
			<c:forEach items="${boardList}" var="board">
				<tr>
					<td style="text-align: center;">${board.seq}</td>
					<td align="left"><a href="getBoard.do?seq=${board.seq}">${board.title}</a></td>
					<td style="text-align: center;">${board.writer}</td>
					<td style="text-align: center;">
					<fmt:formatDate value="${board.regDate}" pattern="yyyy.MM.dd"/>
					</td>
					<td style="text-align: center;">${board.cnt}</td>
				</tr>
			</c:forEach>
		</table>
		<br> <a href="insertBoard.do"><spring:message code="message.board.list.link.insertboard"/></a>
	</center>

</body>
</html>