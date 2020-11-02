<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글등록</title>
</head>
<body>
	<center>
		<h1>글 등록</h1>
		<a href="logout.do">LogOut</a>
		<hr>
		<form action="insertBoard.do" method="post" enctype="multipart/form-data">
			<table border="1" cellpadding="0" cellspacing-="0">
				<tr>
					<td style="background-color: orange; width: 70px;">제목</td>
					<td style="text-align: left"><input type="text" name="title" required=true>
					</td>
				</tr>
				<tr>
					<td style="background-color: orange; width: 70px;">작성자</td>
					<td style="text-align: left">
					<input type="text" name="writer" required=true readonly=true value="${userName}">
					</td>
				</tr>
				<tr>
					<td style="background-color: orange; width: 70px;">내용</td>
					<td style="text-align: left"><textarea rows="10" cols="40"
							name="content" required=true></textarea></td>
				</tr>
				<tr>
					<td style="background-color: orange; width: 70px;">업로드</td>
					<td style="text-align: left"><input type="file" name="uploadFile">
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="새글등록"></td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="getBoardList.do">글목록</a>
	</center>
</body>
</html>