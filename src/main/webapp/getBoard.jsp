<%@page import="java.util.List"%>
<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글상세</title>
<a href="logout.do">LogOut</a>
</head>
<body>
	<center>
		<h1>글상세</h1>
		
		<form action="updateBoard.do" method="post">
		<input type="hidden" name="seq" value="${board.seq}">
			<table border="1" cellpadding="0" cellspacing-="0">
				<tr>
					<td style="background-color: orange; width: 70px;">제목</td>
					<td style="text-align: left"><input type="text" name="title" value="${board.title}">
					</td>
				</tr>
				<tr>
					<td style="background-color: orange; width: 70px;">작성자</td>
					<td style="text-align: left"><input type="text" value="${board.writer}" readonly=true>
					</td>
				</tr>
				<tr>
					<td style="background-color: orange; width: 70px;">내용</td>
					<td style="text-align: left"><textarea rows="10" cols="40"
							name="content">${board.content}</textarea></td>
				</tr>
				<tr>
					<td style="background-color: orange; width: 70px;">등록일</td>
					<td style="text-align: left"><input type="text" value="${board.regDate }" readonly=true>
					</td>
				</tr>
				<tr>
					<td style="background-color: orange; width: 70px;">조회수</td>
					<td style="text-align: left"><input type="text" value="${board.cnt}" readonly=true>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="수정"></td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="insertBoard.do">새글 등록</a> 
		<a href="deleteBoard.do?seq=${board.seq }">글삭제</a> 
		<a href="getBoardList.do">글목록</a>
	</center>

</body>
</html>