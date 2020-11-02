<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
	<title>Insert title here</title>
	<script src="https://kit.fontawesome.com/63820efb51.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/styles.css" />
</head>
<body>
<h1><spring:message code="message.user.login.title"/></h1>
<hr>
<form action="login.do" method="post">
<div class="login-area-outer">
 	<div class="login-area">
		<div id="input-name">
			<span><spring:message code="message.user.login.id"/></span>
			<span><input type="text" name="id" value="${userVO.id }"></input></span>
		</div>
		<div id="input-password">
			<span><spring:message code="message.user.login.password"/></span>
			<span><input type="password" name="password" value="${userVO.password}"></input></span>
		</div>
		<div id="input-password">
			<input type="submit" value="<spring:message code="message.user.login.loginBtn"/>" />
		</div>
	</div>
</div>
</form>
</body>
</html>