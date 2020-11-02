<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>기본 에러 화면</title>
</head>
<body>
	<table style="width: 100%; boarder: 1px solid 000;">
		<tr>
			<td style="text-align:center;background-color:orange;">Null 에러 화면입니다.</td>
		</tr>
	</table>
	<br>
	<table style="width: 100%; boarder: 1px solid 000;">
		<tr>
			<td style="text-align:center;">
				<div style="height:50px;padding:30 30">
					Message : ${exception.message}
				</div>
			</td>
		</tr>
	</table>
</body>
</html>