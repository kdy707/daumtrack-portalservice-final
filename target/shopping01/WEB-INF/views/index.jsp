<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>shopping-mall</title>
	</head>
<body>
	<c:if test="${null == userId}">
		<div>
			<button id="registerBtn" onclick="location.href='register/step1'">회원가입</button>
	</c:if>
	<c:if test="${! empty userId}">
			${userId}
	</c:if>
			<button id="loginBtn" onclick="location.href='login/loginForm'">로그인</button>
		</div>
</body>
</html>