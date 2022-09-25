<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--비밀번호 찾기--%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>아이디 비밀번호 찾기</title>
</head>
<body>
<form action="<c:url value ='/idinfo'/>" method="post">
	<input type="text" name="email" placeholder="email 입력">
	<button>아이디 찾기</button>
</form>

<form action="<c:url value ='/pwdinfo'/>" method="post">
	<input type="text" name="email" placeholder="email 입력">
	<input type="text" name="id" placeholder="id 입력">
	<button>비밀번호 찾기</button>
</form>
</body>
</html>
